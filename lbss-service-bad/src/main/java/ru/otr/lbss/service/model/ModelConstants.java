package ru.otr.lbss.service.model;

import ru.otr.lbss.service.model.types.SmevMember;

public interface ModelConstants {
    static final String UUID_REGEXP = "^[0-9a-fA-F]{8}-[0-9a-fA-F]{4}-[0-9a-fA-F]{4}-[0-9a-fA-F]{4}-[0-9a-fA-F]{12}$";

    static final SmevMember SMEV_AS_MEMBER = new SmevMember("SMEV", "СМЭВ");
}
