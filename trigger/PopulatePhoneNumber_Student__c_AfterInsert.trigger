trigger PopulatePhoneNumber on Student__c (after insert) {
    Set<String> phoneNumbers = new Set<String>();
    List<Student__c> studentsToUpdate = new List<Student__c>();
    for(Student__c student : Trigger.new) {
        if(student.Phone != null) {
            phoneNumbers.add(student.Phone);
        }
    }
    List<Student__c> existingStudents = [SELECT Phone FROM Student__c WHERE Phone IN :phoneNumbers];
    Map<String, Student__c> existingPhoneToStudent = new Map<String, Student__c>();
    for(Student__c existingStudent : existingStudents) {
        existingPhoneToStudent.put(existingStudent.Phone, existingStudent);
    }
    for(Student__c student : Trigger.new) {
        if(student.Phone != null && existingPhoneToStudent.containsKey(student.Phone)) {
            Student__c existingStudent = existingPhoneToStudent.get(student.Phone);
            if(existingStudent.Mobile == null || existingStudent.Mobile == '') {
                existingStudent.Mobile = student.Phone;
                studentsToUpdate.add(existingStudent);
            }
        }
    }
    if(studentsToUpdate.size() > 0) {
        update studentsToUpdate;
    }
}