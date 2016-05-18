package one.dal.support.impl.rules;

import one.dal.support.DataSourceKeyRule;


public abstract class ADataSourceKeyRule implements DataSourceKeyRule {

    protected String field;
    protected boolean readonly = false;
    protected String dataSourceKey;

    public String getField() {
        return field;
    }

    public void setField(String field) {
        this.field = field;
    }

    public boolean isReadonly() {
        return readonly;
    }

    public void setReadonly(boolean readonly) {
        this.readonly = readonly;
    }

    public String getDataSourceKey() {
        return dataSourceKey;
    }

    public void setDataSourceKey(String dataSourceKey) {
        this.dataSourceKey = dataSourceKey;
    }

}
