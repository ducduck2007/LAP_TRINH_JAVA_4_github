package org.example.democud.model;

import jakarta.persistence.*;

import java.util.Date;

@Entity
@Table(name = "StudentAttendance")
public class Attendance {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "AttendanceID")
    private Integer attendanceID;

    @Column(name = "StudentName")
    private String studentName;

    @Temporal(TemporalType.DATE)
    @Column(name = "ClassDate")
    private Date classDate;

    @Column(name = "Status")
    @Enumerated(EnumType.STRING)
    private AttendanceStatus status;

    public Integer getAttendanceID() {
        return attendanceID;
    }

    public void setAttendanceID(Integer attendanceID) {
        this.attendanceID = attendanceID;
    }

    public String getStudentName() {
        return studentName;
    }

    public void setStudentName(String studentName) {
        this.studentName = studentName;
    }

    public Date getClassDate() {
        return classDate;
    }

    public void setClassDate(Date classDate) {
        this.classDate = classDate;
    }

    public AttendanceStatus getStatus() {
        return status;
    }

    public void setStatus(AttendanceStatus status) {
        this.status = status;
    }
}
