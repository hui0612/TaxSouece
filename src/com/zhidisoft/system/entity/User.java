package com.zhidisoft.system.entity;
/**
 *
 *private int id;
 *private String username用户名;
 *private String password;用户密码;
 *private int taxerId员工编号;
 *private String salt用户盐值;
 *private int permissionId用户权限;
 *private int state用户状态;
 *private String email用户工作邮箱;
 * @<code>用户表tb_user</code>
 *
 * */
public class User {
    private int id;
    private String username;//用户名
    private String password;//用户密码
    private int taxerId;//员工编号
    private String salt;//用户盐值
    private int permissionId;//用户权限
    private int state;//用户状态
    private String email;//用户工作邮箱

    public User() {
    }

    public User(int id, String username, String password, int taxerId, String salt, int permissionId, int state, String email) {
        this.id = id;
        this.username = username;
        this.password = password;
        this.taxerId = taxerId;
        this.salt = salt;
        this.permissionId = permissionId;
        this.state = state;
        this.email = email;
    }

    public User(String username, String password) {
        this.username = username;
        this.password = password;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public int getTaxerId() {
        return taxerId;
    }

    public void setTaxerId(int taxerId) {
        this.taxerId = taxerId;
    }

    public String getSalt() {
        return salt;
    }

    public void setSalt(String salt) {
        this.salt = salt;
    }

    public int getPermissionId() {
        return permissionId;
    }

    public void setPermissionId(int permissionId) {
        this.permissionId = permissionId;
    }

    public int getState() {
        return state;
    }

    public void setState(int state) {
        this.state = state;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", username='" + username + '\'' +
                ", password='" + password + '\'' +
                ", taxerId=" + taxerId +
                ", salt='" + salt + '\'' +
                ", permissionId=" + permissionId +
                ", state=" + state +
                ", email='" + email + '\'' +
                '}';
    }
}
