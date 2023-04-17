Apex Class:public class AccountNotification { 

// The System Admin's email address
public static String systemAdminEmail = 'systemAdmin@email.com';

// The email subject
public static String emailSubject = 'New account got created';

// Method to send the email notification
public static void sendEmailNotification(Account newAccount) {

// Get the account owner's contact information
String accountOwnerName = newAccount.Owner.Name;
String accountOwnerEmail = newAccount.Owner.Email;

// Create the message body
String messageBody = 'A new account has been created with the name ' + newAccount.Name + 
' on ' + newAccount.CreatedDate + '\nAccount Owner Contact Information: \n' + 
'Name: ' + accountOwnerName + '\n' + 'Email: ' + accountOwnerEmail;

// Create the email message
Messaging.SingleEmailMessage email = new Messaging.SingleEmailMessage();

// Set the email recipient
email.setToAddresses(new String[] { systemAdminEmail });

// Set the email subject
email.setSubject(emailSubject);

// Set the email body
email.setPlainTextBody(messageBody);

// Send the email
Messaging.sendEmail(new Messaging.SingleEmailMessage[] { email });
}

// Trigger to send the email when a new account is inserted
trigger AccountNotificationTrigger on Account (after insert) {
for (Account newAccount : Trigger.new) {
AccountNotification.sendEmailNotification(newAccount);
}
}

}