package taskT;

public class User {
   
   private String name;
   private String id;
   private String password;
   private String phoneNumber;
   
   public User() {;}
   
   public String getName() {
      return name;
   }
   public void setName(String name) {
      this.name = name;
   }
   public String getId() {
      return id;
   }
   public void setId(String id) {
      this.id = id;
   }
   public String getPassword() {
      return password;
   }
   public void setPassword(String password) {
      this.password = password;
   }
   public String getPhoneNumber() {
      return phoneNumber;
   }
   public void setPhoneNumber(String phoneNumber) {
      this.phoneNumber = phoneNumber;
   }
   
   
   private String decrypt(String password) {
      String decryptedPassword = "";
      for (int i = 0; i < password.length(); i++) {
         decryptedPassword += (char)(password.charAt(i) / 3);
      }
      return decryptedPassword;
   }
   
   @Override
   public String toString() {
      String str = name + "," + id + "," + phoneNumber + "," + decrypt(password);
      return str;
   }
}















