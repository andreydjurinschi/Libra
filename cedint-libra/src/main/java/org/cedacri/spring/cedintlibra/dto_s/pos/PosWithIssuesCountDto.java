package org.cedacri.spring.cedintlibra.dto_s.pos;

public class PosWithIssuesCountDto {
    private String name;
    private Integer issuesCount;

    public PosWithIssuesCountDto(String name, Integer issuesCount) {
        this.name = name;
        this.issuesCount = issuesCount;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getIssuesCount() {
        return issuesCount;
    }

    public void setIssuesCount(Integer issuesCount) {
        this.issuesCount = issuesCount;
    }
}
