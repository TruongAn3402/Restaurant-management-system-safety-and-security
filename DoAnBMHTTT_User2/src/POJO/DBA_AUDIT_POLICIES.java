/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package POJO;

/**
 *
 * @author Admin
 */
public class DBA_AUDIT_POLICIES {
    String Object_schema, Object_name, Policy_owner, Policy_name, Policy_column;

    public DBA_AUDIT_POLICIES(String Object_schema, String Object_name, String Policy_owner, String Policy_name, String Policy_column) {
        this.Object_schema = Object_schema;
        this.Object_name = Object_name;
        this.Policy_owner = Policy_owner;
        this.Policy_name = Policy_name;
        this.Policy_column = Policy_column;
    }

    public DBA_AUDIT_POLICIES() {
    }

    public String getObject_schema() {
        return Object_schema;
    }

    public void setObject_schema(String Object_schema) {
        this.Object_schema = Object_schema;
    }

    public String getObject_name() {
        return Object_name;
    }

    public void setObject_name(String Object_name) {
        this.Object_name = Object_name;
    }

    public String getPolicy_owner() {
        return Policy_owner;
    }

    public void setPolicy_owner(String Policy_owner) {
        this.Policy_owner = Policy_owner;
    }

    public String getPolicy_name() {
        return Policy_name;
    }

    public void setPolicy_name(String Policy_name) {
        this.Policy_name = Policy_name;
    }

    public String getPolicy_column() {
        return Policy_column;
    }

    public void setPolicy_column(String Policy_column) {
        this.Policy_column = Policy_column;
    }
}
