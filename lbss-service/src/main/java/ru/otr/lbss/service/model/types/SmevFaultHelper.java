package ru.otr.lbss.service.model.types;

import cxc.jex.common.exception.ExceptionWrapper;
import cxc.jex.common.failure.FailureWrapper;
import ru.otr.lbss.client.model.types.basic.SmevFault;
import ru.otr.lbss.client.model.types.fault.InvalidContent;

public class SmevFaultHelper {

    public static SmevFault failure2SmevFault(FailureWrapper failure) {
        SmevFault result;
        if (failure.getCause() instanceof ExceptionWrapper) {
            ExceptionWrapper ew = (ExceptionWrapper) failure.getCause();
            switch (ew.getCode()) {
            case "SMEV.InvalidContent":
                InvalidContent fault = new InvalidContent();
                fault.setCode(ew.getCode());
                fault.setDescription(ew.getMessage());
                result = fault;
                break;
            default:
                result = new SmevFault();
                result.setCode(ew.getCode());
                result.setDescription(ew.getMessage());
            }
        } else {
            result = new SmevFault();
            result.setCode(failure.getCause().getClass().getName());
            result.setDescription(failure.getCause().getMessage());
        }
        return result;
    }

}
