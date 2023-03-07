package com.eberts.shop.models.vo.security;

import java.util.Date;
import java.util.Objects;

public class TokenVo {

    private String username;
    private boolean autenticated;
    private Date created;
    private Date expiration;
    private String accessToken;
    private String refreshToken;

    public TokenVo() {
    }

    public TokenVo(String username, boolean authenticated, Date created, Date expiration, String accessToken, String refreshToken) {
        this.username = username;
        this.autenticated = authenticated;
        this.created = created;
        this.expiration = expiration;
        this.accessToken = accessToken;
        this.refreshToken = refreshToken;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public boolean isAutenticated() {
        return autenticated;
    }

    public void setAutenticated(boolean autenticated) {
        this.autenticated = autenticated;
    }

    public Date getCreated() {
        return created;
    }

    public void setCreated(Date created) {
        this.created = created;
    }

    public Date getExpiration() {
        return expiration;
    }

    public void setExpiration(Date expiration) {
        this.expiration = expiration;
    }

    public String getAccessToken() {
        return accessToken;
    }

    public void setAccessToken(String accessToken) {
        this.accessToken = accessToken;
    }

    public String getRefreshToken() {
        return refreshToken;
    }

    public void setRefreshToken(String refreshToken) {
        this.refreshToken = refreshToken;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof TokenVo tokenVo)) return false;
        return autenticated == tokenVo.autenticated && Objects.equals(username, tokenVo.username) && Objects.equals(created, tokenVo.created) && Objects.equals(expiration, tokenVo.expiration) && Objects.equals(accessToken, tokenVo.accessToken) && Objects.equals(refreshToken, tokenVo.refreshToken);
    }

    @Override
    public int hashCode() {
        return Objects.hash(username, autenticated, created, expiration, accessToken, refreshToken);
    }
}
