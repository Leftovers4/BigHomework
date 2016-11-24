package util;

/**
 * Created by Hiki on 11/19/2016.
 */
public enum PersonnelType {

    /**
     * 酒店工作人员
     */
    HotelWorker,

    /**
     * 网站营销人员
     */
    WebMarketer,

    /**
     * 网站管理人员
     */
    WebAdministrator;

    public static PersonnelType getType(String name) {
        switch (name) {
            case "HotelWorker":
                return PersonnelType.HotelWorker;
            case "WebMarketer":
                return PersonnelType.WebMarketer;
            case "WebAdministrator":
                return PersonnelType.WebAdministrator;

        }
        // TODO：这种方式可能会导致错误，需要对输入有极高的准确性要求
        return null;
    }


}
