package cn.macrotea.showcase.dto;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

/**
 * @author macrotea@qq.com
 * @since 2014-7-28 上午9:58
 */
public class DomainAndAction {

    public static final String KEY = "domainAndAction";

    private String domain;

    private String action;

    private String domainDesc;

    private String actionDesc;

    public DomainAndAction(String domain, String action, String domainDesc, String actionDesc) {
        this.domain = domain;
        this.action = action;
        this.domainDesc = domainDesc;
        this.actionDesc = actionDesc;
    }

    public String getDomain() {
        return domain;
    }

    public void setDomain(String domain) {
        this.domain = domain;
    }

    public String getAction() {
        return action;
    }

    public void setAction(String action) {
        this.action = action;
    }

    public String getDomainDesc() {
        return domainDesc;
    }

    public void setDomainDesc(String domainDesc) {
        this.domainDesc = domainDesc;
    }

    public String getActionDesc() {
        return actionDesc;
    }

    public void setActionDesc(String actionDesc) {
        this.actionDesc = actionDesc;
    }

    @Override
    public String toString() {
        return ToStringBuilder.reflectionToString(this, ToStringStyle.SHORT_PREFIX_STYLE);
    }
}
