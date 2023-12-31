package com.complete.rt.db.account;

import com.complete.rt.db.BaseCreateDateTimeEntity;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class AccountDeleteLog extends BaseCreateDateTimeEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long sn;

    @Column(nullable = false, updatable = false)
    private Long accountSn;

    @Column(nullable = false, updatable = false)
    private String id;

    @Column(nullable = false, updatable = false)
    private String phone;

    @Column(nullable = false, updatable = false)
    private String ip;

    public static AccountDeleteLog create(Account account, String ip) {
        AccountDeleteLog accountDeleteLog = new AccountDeleteLog();
        accountDeleteLog.accountSn = account.getSn();
        accountDeleteLog.id = account.getId();
        accountDeleteLog.phone = account.getPhone();
        accountDeleteLog.ip = ip;
        return accountDeleteLog;
    }
}
