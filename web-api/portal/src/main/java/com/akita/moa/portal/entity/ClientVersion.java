package com.akita.moa.portal.entity;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class ClientVersion {
    private String version;

    private String platform;

    private String upgradeLog;
}
