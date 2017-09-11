package in.zipgo.automation_framework.enums;

import in.zipgo.automation_framework.request.data.Session;

public enum SessionEnums implements Supplier<Session> {
    VALID_SESSION_INFO {
        @Override
        public Session getData() {
            throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        }
    };
}
