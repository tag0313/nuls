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
package io.nuls.db.entity;

public class DelegatePo {
    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column delegate.id
     *
     * @mbg.generated
     */
    private String id;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column delegate.address
     *
     * @mbg.generated
     */
    private String address;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column delegate.agent_address
     *
     * @mbg.generated
     */
    private String agentAddress;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column delegate.deposit
     *
     * @mbg.generated
     */
    private Long deposit;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column delegate.status
     *
     * @mbg.generated
     */
    private Integer status;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column delegate.time
     *
     * @mbg.generated
     */
    private Long time;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column delegate.block_height
     *
     * @mbg.generated
     */
    private Long blockHeight;

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column delegate.id
     *
     * @return the value of delegate.id
     *
     * @mbg.generated
     */
    public String getId() {
        return id;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column delegate.id
     *
     * @param id the value for delegate.id
     *
     * @mbg.generated
     */
    public void setId(String id) {
        this.id = id == null ? null : id.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column delegate.address
     *
     * @return the value of delegate.address
     *
     * @mbg.generated
     */
    public String getAddress() {
        return address;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column delegate.address
     *
     * @param address the value for delegate.address
     *
     * @mbg.generated
     */
    public void setAddress(String address) {
        this.address = address == null ? null : address.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column delegate.agent_address
     *
     * @return the value of delegate.agent_address
     *
     * @mbg.generated
     */
    public String getAgentAddress() {
        return agentAddress;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column delegate.agent_address
     *
     * @param agentAddress the value for delegate.agent_address
     *
     * @mbg.generated
     */
    public void setAgentAddress(String agentAddress) {
        this.agentAddress = agentAddress == null ? null : agentAddress.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column delegate.deposit
     *
     * @return the value of delegate.deposit
     *
     * @mbg.generated
     */
    public Long getDeposit() {
        return deposit;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column delegate.deposit
     *
     * @param deposit the value for delegate.deposit
     *
     * @mbg.generated
     */
    public void setDeposit(Long deposit) {
        this.deposit = deposit;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column delegate.status
     *
     * @return the value of delegate.status
     *
     * @mbg.generated
     */
    public Integer getStatus() {
        return status;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column delegate.status
     *
     * @param status the value for delegate.status
     *
     * @mbg.generated
     */
    public void setStatus(Integer status) {
        this.status = status;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column delegate.time
     *
     * @return the value of delegate.time
     *
     * @mbg.generated
     */
    public Long getTime() {
        return time;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column delegate.time
     *
     * @param time the value for delegate.time
     *
     * @mbg.generated
     */
    public void setTime(Long time) {
        this.time = time;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column delegate.block_height
     *
     * @return the value of delegate.block_height
     *
     * @mbg.generated
     */
    public Long getBlockHeight() {
        return blockHeight;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column delegate.block_height
     *
     * @param blockHeight the value for delegate.block_height
     *
     * @mbg.generated
     */
    public void setBlockHeight(Long blockHeight) {
        this.blockHeight = blockHeight;
    }
}
