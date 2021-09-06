package ru.otr.lbss.service.processing;

import cxc.jex.common.failure.FailureWrapper;

public abstract class ProcessingTask implements Runnable {
    private boolean async;
    private FailureWrapper failure;

    public ProcessingTask(boolean async) {
        this.async = async;
    }

    public boolean isAsync() {
        return async;
    }

    public FailureWrapper getFailure() {
        return failure;
    }

    public void setFailure(FailureWrapper failure) {
        this.failure = failure;
    }

}
