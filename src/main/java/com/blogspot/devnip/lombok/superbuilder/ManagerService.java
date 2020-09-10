package com.blogspot.devnip.lombok.superbuilder;

/**
 * Provides operational methods on Manager entity.
 */
public class ManagerService {

    /**
     * Create a dummy Manager object for testing.
     *
     * @return
     */
    public Manager createDummyManager() {
        return Manager.builder()
                .id("001")
                .name("James Smith")
                .promotionDate("2010-07-18")
                .build();
    }
}
