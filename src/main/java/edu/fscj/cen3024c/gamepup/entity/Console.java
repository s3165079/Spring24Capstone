package edu.fscj.cen3024c.gamepup.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "console")
public class Console{
    //fields
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "console_id")
    private Integer consoleId;
    @Column(name = "console_name")
    private String consoleName;

    //constructor
    public Console(){}

    //getters and setters
    public Integer getConsoleId() { return consoleId; }
    public String getConsoleName() { return consoleName; }
    public void setConsoleName(String consoleName) { this.consoleName = consoleName; }
}
