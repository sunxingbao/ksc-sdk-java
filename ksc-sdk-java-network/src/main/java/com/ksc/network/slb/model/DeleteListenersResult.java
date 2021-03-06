package com.ksc.network.slb.model;

import java.io.Serializable;

import lombok.ToString;

/**
 * Created by LIUHONGMING on 2017/4/25.
 */
@ToString
public class DeleteListenersResult implements Serializable, Cloneable {

    /**
     * 请求ID
     */
    private String RequestId;

    /**
     * 操作是否成功
     */
    private Boolean Return;

    public String getRequestId() {
        return RequestId;
    }

    public void setRequestId(String requestId) {
        RequestId = requestId;
    }

    public Boolean getReturn() {
        return Return;
    }

    public void setReturn(Boolean aReturn) {
        Return = aReturn;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        DeleteListenersResult that = (DeleteListenersResult) o;

        if (RequestId != null ? !RequestId.equals(that.RequestId) : that.RequestId != null) return false;
        return Return != null ? Return.equals(that.Return) : that.Return == null;
    }

    @Override
    public int hashCode() {
        int result = RequestId != null ? RequestId.hashCode() : 0;
        result = 31 * result + (Return != null ? Return.hashCode() : 0);
        return result;
    }

    @Override
    public DeleteListenersResult clone() {
        try {
            return (DeleteListenersResult) super.clone();
        } catch (CloneNotSupportedException e) {
            throw new IllegalStateException(
                    "Got a CloneNotSupportedException from Object.clone() "
                            + "even though we're Cloneable!", e);
        }
    }
}
