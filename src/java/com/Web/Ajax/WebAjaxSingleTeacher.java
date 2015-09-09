/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.Web.Ajax;

/**
 *
 * @author wilson.li
 */
public class WebAjaxSingleTeacher 
{
    private String teacherName;
    private String teacherId;
    private String specialistSubject;

    public WebAjaxSingleTeacher(String teacherName, String teacherId, String specialistSubject) {
        this.teacherName = teacherName;
        this.teacherId = teacherId;
        this.specialistSubject = specialistSubject;
    }

    public String getTeacherName() {
        return teacherName;
    }

    public void setTeacherName(String teacherName) {
        this.teacherName = teacherName;
    }

    public String getTeacherId() {
        return teacherId;
    }

    public void setTeacherId(String teacherId) {
        this.teacherId = teacherId;
    }

    public String getSpecialistSubject() {
        return specialistSubject;
    }

    public void setSpecialistSubject(String specialistSubject) {
        this.specialistSubject = specialistSubject;
    }
    
    
    
    
}
