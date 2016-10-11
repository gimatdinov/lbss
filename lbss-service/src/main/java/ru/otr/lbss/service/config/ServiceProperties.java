package ru.otr.lbss.service.config;

public interface ServiceProperties {

    final static String PrimeService_mode = "LBSS.service.PrimeService_mode";
    final static String SignService_mode = "LBSS.service.SignService_mode";
    final static String FTPService_mode = "LBSS.service.FTPService_mode";
    final static String MemberService_mode = "LBSS.service.MemberService_mode";

    final static String ftp_directory = "LBSS.service.ftp_directory";
    final static String ftp_port = "LBSS.service.ftp_port";
    final static String ftp_passive_ports = "LBSS.service.ftp_passive_ports";
    final static String ftp_admin_password = "LBSS.service.ftp_admin_password";
    final static String ftp_log_enable = "LBSS.service.ftp_log_enable";
    final static String ftp_users_list = "LBSS.service.ftp_users_list";
    final static String ftp_users_database = "LBSS.service.ftp_users_database";

    final static String PrimeService_acknowledgmentTimeout = "LBSS.service.PrimeService_acknowledgmentTimeout";

    final static String SignService_cryptoWebServiceURI = "LBSS.service.SignService_cryptoWebServiceURI";

}
