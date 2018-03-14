/**
 * MIT License
 * <p>
 * Copyright (c) 2017-2018 nuls.io
 * <p>
 * Permission is hereby granted, free of charge, to any person obtaining a copy
 * of this software and associated documentation files (the "Software"), to deal
 * in the Software without restriction, including without limitation the rights
 * to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
 * copies of the Software, and to permit persons to whom the Software is
 * furnished to do so, subject to the following conditions:
 * <p>
 * The above copyright notice and this permission notice shall be included in all
 * copies or substantial portions of the Software.
 * <p>
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
 * IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
 * FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
 * AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
 * LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
 * OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE
 * SOFTWARE.
 */
package io.nuls.db.dao.impl.mybatis;

import com.github.pagehelper.PageHelper;
import io.nuls.core.utils.crypto.Hex;
import io.nuls.core.utils.str.StringUtils;
import io.nuls.db.dao.TransactionDataService;
import io.nuls.db.dao.impl.mybatis.mapper.TransactionMapper;
import io.nuls.db.dao.impl.mybatis.util.Condition;
import io.nuls.db.dao.impl.mybatis.util.SearchOperator;
import io.nuls.db.dao.impl.mybatis.util.Searchable;
import io.nuls.db.entity.TransactionPo;
import io.nuls.db.transactional.annotation.DbSession;
import io.nuls.db.transactional.annotation.PROPAGATION;

import java.util.List;
import java.util.Map;

/**
 * @author Niels
 * @date 2017/11/22
 */
@DbSession(transactional = PROPAGATION.NONE)
public class TransactionDaoImpl extends BaseDaoImpl<TransactionMapper, String, TransactionPo> implements TransactionDataService {
    public TransactionDaoImpl() {
        super(TransactionMapper.class);
    }

    @Override
    protected Searchable getSearchable(Map<String, Object> params) {
        //todo
        return null;
    }

    @Override
    public List<TransactionPo> getTxs(Long blockHeight) {
        Searchable searchable = new Searchable();
        searchable.addCondition("block_height", SearchOperator.eq, blockHeight);
        PageHelper.orderBy("create_time asc");
        return getMapper().selectList(searchable);
    }

    @Override
    public List<TransactionPo> getTxs(Long blockHeight, int pageNum, int pageSize) {
        PageHelper.startPage(pageNum, pageSize);
        Searchable searchable = new Searchable();
        searchable.addCondition("block_height", SearchOperator.eq, blockHeight);
        PageHelper.orderBy("create_time asc");
        return getMapper().selectList(searchable);
    }

    @Override
    public List<TransactionPo> getTxs(Long startHeight, Long endHeight) {
        Searchable searchable = new Searchable();
        searchable.addCondition("block_height", SearchOperator.gte, startHeight);
        searchable.addCondition("block_height", SearchOperator.lte, endHeight);
        PageHelper.orderBy("block_height asc, tx_index asc");
        return getMapper().selectList(searchable);
    }

    @Override
    public List<TransactionPo> getTxs(String address, int type, Integer pageNumber, Integer pageSize) {
        Searchable searchable = new Searchable();
        if (StringUtils.isBlank(address)) {
            if (type != 0) {
                searchable.addCondition("a.type", SearchOperator.eq, type);
            }
            if (pageNumber != null && pageSize != null) {
                PageHelper.startPage(pageNumber, pageSize);
            }
            PageHelper.orderBy("a.create_time desc");
            return getMapper().selectList(searchable);
        }

        Condition condition = Condition.custom("(e.address = c.address or e.address = d.address)");
        searchable.addCondition(condition);
        if (type != 0) {
            searchable.addCondition("a.type", SearchOperator.eq, type);
        }
        searchable.addCondition("e.address", SearchOperator.eq, address);


        if (pageNumber != null && pageSize != null) {
            PageHelper.startPage(pageNumber, pageSize);
        }
        PageHelper.orderBy("a.create_time desc");
        return getMapper().selectByAddress(searchable);
    }

    @Override
    public List<TransactionPo> getTxs(String address, int type) {
        return getTxs(address, type, null, null);
    }

    @Override
    public long getTxsCount(String address, int type) {
        Searchable searchable = new Searchable();
        if (StringUtils.isBlank(address)) {
            if (type != 0) {
                searchable.addCondition("type", SearchOperator.eq, type);
            }
            return getMapper().selectCount(searchable);
        }

        if (type != 0) {
            searchable.addCondition("a.type", SearchOperator.eq, type);
        }
        searchable.addCondition("e.address", SearchOperator.eq, address);
        return getMapper().selectCountByAddress(searchable);
    }

    @Override
    public long getFeeByHeight(long blockHeight) {
        return getMapper().getFeeByHeight(blockHeight);
    }

}
