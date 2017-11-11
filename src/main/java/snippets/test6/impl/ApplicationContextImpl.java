package snippets.test6.impl;

import snippets.test6.ApplicationContext;

public class ApplicationContextImpl implements ApplicationContext {
    @Override
    public <T> T getBean(String id, Class<T> type) {
        return null;
    }

    @Override
    public Object getBean(String id) {
        return null;
    }
}
