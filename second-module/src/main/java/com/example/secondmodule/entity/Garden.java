/**
 * @FileName: Garden.java
 * @Copyright: soyea©2018
 * @Description: 小区或苑的实体类文件
 * @Author: ywm
 * @Createtime: 2018/01/22 12:39
 * @Modifier: 2018/01/22 12:39
 * @TrackNo:
 * @ModifiedNo:
 * @ModifiedContent:
 */
package com.example.secondmodule.entity;

import java.util.Date;

/**
 * @Name: Garden
 * @Description: 小区或苑的实体类
 * @Author: ywm
 * @Version: v0.0.1-2018/01/22
 * @See:
 * @Since:
 */
public class Garden extends BaseEntity {

    private String gardenName;    //小区/苑名称
    private String gardenZipCode;    //小区/苑邮编
    private Long gardenRegionId;    //小区/苑所在区域ID
    private String gardenAddr;    //小区/苑详细地址
    private Date gardenEstablishYear;    //小区/苑建立年代
    private String gardenTel;    //小区/苑电话
    private String gardenPic;    //小区/苑概貌图片地址
    private Integer gardenCarportCount; //小区车位总数

    public void setGardenName(String gardenName) {
        this.gardenName = gardenName;
    }

    public String getGardenName() {
        return gardenName;
    }

    public void setGardenZipCode(String gardenZipCode) {
        this.gardenZipCode = gardenZipCode;
    }

    public String getGardenZipCode() {
        return gardenZipCode;
    }

    public void setGardenRegionId(Long gardenRegionId) {
        this.gardenRegionId = gardenRegionId;
    }

    public Long getGardenRegionId() {
        return gardenRegionId;
    }

    public void setGardenAddr(String gardenAddr) {
        this.gardenAddr = gardenAddr;
    }

    public String getGardenAddr() {
        return gardenAddr;
    }

    public void setGardenEstablishYear(Date gardenEstablishYear) {
        this.gardenEstablishYear = gardenEstablishYear;
    }

    public Date getGardenEstablishYear() {
        return gardenEstablishYear;
    }

    public void setGardenTel(String gardenTel) {
        this.gardenTel = gardenTel;
    }

    public String getGardenTel() {
        return gardenTel;
    }

    public void setGardenPic(String gardenPic) {
        this.gardenPic = gardenPic;
    }

    public String getGardenPic() {
        return gardenPic;
    }

    public Integer getGardenCarportCount() {
        return gardenCarportCount;
    }

    public void setGardenCarportCount(Integer gardenCarportCount) {
        this.gardenCarportCount = gardenCarportCount;
    }


    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", id=").append(getId());
        sb.append(", gardenName=").append(gardenName);
        sb.append(", gardenZipCode=").append(gardenZipCode);
        sb.append(", gardenRegionId=").append(gardenRegionId);
        sb.append(", gardenAddr=").append(gardenAddr);
        sb.append(", gardenEstablishYear=").append(gardenEstablishYear);
        sb.append(", gardenTel=").append(gardenTel);
        sb.append(", gardenPic=").append(gardenPic);
        sb.append(", gardenCarportCount=").append(gardenCarportCount);
        sb.append(", createTime=").append(getCreateTime());
        sb.append(", modifiedTime=").append(getModifiedTime());
        sb.append(", remark=").append(getRemark());
        sb.append("]");
        return sb.toString();
    }

    @Override
    public boolean equals(Object that) {
        if (this == that) {
            return true;
        }
        if (that == null) {
            return false;
        }
        if (getClass() != that.getClass()) {
            return false;
        }
        Garden other = (Garden) that;
        return (this.getId() == null ? other.getId() == null : this.getId().equals(other.getId()))
                && (this.getGardenName() == null ? other.getGardenName() == null : this.getGardenName().equals(other.getGardenName()))
                && (this.getGardenZipCode() == null ? other.getGardenZipCode() == null : this.getGardenZipCode().equals(other.getGardenZipCode()))
                && (this.getGardenRegionId() == null ? other.getGardenRegionId() == null : this.getGardenRegionId().equals(other.getGardenRegionId()))
                && (this.getGardenAddr() == null ? other.getGardenAddr() == null : this.getGardenAddr().equals(other.getGardenAddr()))
                && (this.getGardenEstablishYear() == null ? other.getGardenEstablishYear() == null : this.getGardenEstablishYear().equals(other.getGardenEstablishYear()))
                && (this.getGardenTel() == null ? other.getGardenTel() == null : this.getGardenTel().equals(other.getGardenTel()))
                && (this.getGardenPic() == null ? other.getGardenPic() == null : this.getGardenPic().equals(other.getGardenPic()))
                && (this.getGardenCarportCount() == null ? other.getGardenCarportCount() == null : this.getGardenCarportCount().equals(other.getGardenCarportCount()))
                && (this.getValidState() == null ? other.getValidState() == null : this.getValidState().equals(other.getValidState()))
                && (this.getCreateTime() == null ? other.getCreateTime() == null : this.getCreateTime().equals(other.getCreateTime()))
                && (this.getModifiedTime() == null ? other.getModifiedTime() == null : this.getModifiedTime().equals(other.getModifiedTime()))
                && (this.getRemark() == null ? other.getRemark() == null : this.getRemark().equals(other.getRemark()));
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getId() == null) ? 0 : getId().hashCode());
        result = prime * result + ((getGardenName() == null) ? 0 : getGardenName().hashCode());
        result = prime * result + ((getGardenZipCode() == null) ? 0 : getGardenZipCode().hashCode());
        result = prime * result + ((getGardenRegionId() == null) ? 0 : getGardenRegionId().hashCode());
        result = prime * result + ((getGardenAddr() == null) ? 0 : getGardenAddr().hashCode());
        result = prime * result + ((getGardenEstablishYear() == null) ? 0 : getGardenEstablishYear().hashCode());
        result = prime * result + ((getGardenTel() == null) ? 0 : getGardenTel().hashCode());
        result = prime * result + ((getGardenPic() == null) ? 0 : getGardenPic().hashCode());
        result = prime * result + ((getGardenCarportCount() == null) ? 0 : getGardenCarportCount().hashCode());
        result = prime * result + ((getValidState() == null) ? 0 : getValidState().hashCode());
        result = prime * result + ((getCreateTime() == null) ? 0 : getCreateTime().hashCode());
        result = prime * result + ((getModifiedTime() == null) ? 0 : getModifiedTime().hashCode());
        result = prime * result + ((getRemark() == null) ? 0 : getRemark().hashCode());
        return result;
    }
}
