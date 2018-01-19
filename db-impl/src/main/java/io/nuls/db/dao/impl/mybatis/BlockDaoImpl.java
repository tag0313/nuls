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

import io.nuls.db.dao.BlockHeaderService;
import io.nuls.db.dao.impl.mybatis.mapper.BlockMapper;
import io.nuls.db.dao.impl.mybatis.params.BlockSearchParams;
import io.nuls.db.dao.impl.mybatis.util.Searchable;
import io.nuls.db.entity.BlockHeaderPo;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author v.chou
 * @date 2017/9/29
 */
public class BlockDaoImpl extends BaseDaoImpl<BlockMapper, String, BlockHeaderPo> implements BlockHeaderService {

    public BlockDaoImpl() {
        super(BlockMapper.class);
    }

    @Override
    protected Searchable getSearchable(Map<String, Object> params) {
        return new BlockSearchParams(params);
    }

    @Override
    public BlockHeaderPo getHeader(long height) {
        Map<String, Object> params = new HashMap<>();
        params.put(BlockSearchParams.SEARCH_FIELD_HEIGHT,height);
        List<BlockHeaderPo> list = this.getList(params);
        if(null==list||list.isEmpty()){
            return null;
        }
        return list.get(0);
    }

    @Override
    public long getBestHeight() {
        // todo auto-generated method stub(niels)
        return 0;
    }

    @Override
    public BlockHeaderPo getBestBlockHeader() {
        // todo auto-generated method stub(niels)
        return null;
    }

    @Override
    public BlockHeaderPo getHeader(String hash) {
        // todo auto-generated method stub(niels)
        return null;
    }


    @Override
    public List<BlockHeaderPo> getHeaderList(long startHeight, long endHeight) {
        // todo auto-generated method stub(niels)
        return null;
    }

}
