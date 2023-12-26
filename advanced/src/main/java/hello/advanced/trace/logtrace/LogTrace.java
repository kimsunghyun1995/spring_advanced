package hello.advanced.trace.logtrace;

import hello.advanced.trace.TraceStatus;

public interface LogTrace {
    public TraceStatus begin(String message);

    void end(TraceStatus status);
    void exception(TraceStatus status, Exception e);
}
