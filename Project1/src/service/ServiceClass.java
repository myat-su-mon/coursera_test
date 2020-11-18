package service;

import java.io.UnsupportedEncodingException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Arrays;
import java.util.Base64;
import java.util.Date;
import java.util.Properties;

import javax.crypto.Cipher;
import javax.crypto.spec.SecretKeySpec;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

public class ServiceClass {
	
    public String PswToPswCode(String t) {
        String str = "";
        for (int i = 0; i < t.length(); i++) {
            char c = t.charAt(i);
            int j = 0;//Integer.parseInt(String.valueOf(c));
            j += 3;
            j %= 128;
            c += 4;
            str += Character.toString(c);
        }
        return str;
    }

    public String PasswordGenerate() {
        //Password Generate
        String psw = "";
        String cap[] = new String[]{"A", "B", "D", "E", "F", "G", "H", "J",
            "K", "L", "M", "N", "Q", "R", "T", "U", "W", "X", "Y", "Z"};
        String sma[] = new String[]{"a", "b", "d", "e", "f", "g", "h", "i",
            "j", "k", "m", "n", "q", "r", "t", "u", "w", "y", "z"};
        String dig[] = new String[]{"1", "2", "3", "4", "5", "6", "7", "8", "9"};
        String spe[] = new String[]{"!", "@", "$", "*", "&"};

        psw += sma[(int) (sma.length * Math.random())];
        psw += spe[(int) (spe.length * Math.random())];
        psw += cap[(int) (cap.length * Math.random())];
        psw += dig[(int) (dig.length * Math.random())];
        psw += sma[(int) (sma.length * Math.random())];
        psw += cap[(int) (cap.length * Math.random())];
        return psw;
    }

    public String EncDec(String text, int val) {//val 1 for encode, 2 for decode
        SecretKeySpec secretKey = null;
        byte[] key;
        String myKey = "12345";

        //setKey
        MessageDigest sha = null;
        try {
            key = myKey.getBytes("UTF-8");
            sha = MessageDigest.getInstance("SHA-1");
            key = sha.digest(key);
            key = Arrays.copyOf(key, 16);
            secretKey = new SecretKeySpec(key, "AES");
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }

        if (val == 1) {
            try {
                //setKey(secret);
                Cipher cipher = Cipher.getInstance("AES/ECB/PKCS5Padding");
                cipher.init(Cipher.ENCRYPT_MODE, secretKey);
                return Base64.getEncoder().encodeToString(cipher.doFinal(text.getBytes("UTF-8")));
            } catch (Exception e) {
                System.out.println("Error while encrypting: " + e.toString());
            }
            return null;
        } else if (val == 2) {
            try {
                //setKey(secret);
                Cipher cipher = Cipher.getInstance("AES/ECB/PKCS5PADDING");
                cipher.init(Cipher.DECRYPT_MODE, secretKey);
                return new String(cipher.doFinal(Base64.getDecoder().decode(text)));
            } catch (Exception e) {
                System.out.println("Error while decrypting: " + e.toString());
            }
        }

        return "aa";
    }
    
    public boolean sendEmail(String toMail, String subject, String toMessage) {
        //Creating a result for getting status that messsage is delivered or not!
        String result;
        // Get recipient's email-ID, message & subject-line from index.html page

        // Sender's email ID and password needs to be mentioned
        final String from = "zawlwintun@ucsy.edu.mm";
        final String pass = "Fortisrex1412$";

        // Defining the gmail host
        String host = "smtp.office365.com";

        // Creating Properties object
        Properties props = new Properties();

        // Defining properties
        props.put("mail.smtp.host", host);
        props.put("mail.transport.protocol", "smtp");
        props.put("mail.smtp.auth", "true");
        props.put("mail.smtp.starttls.enable", "true");
        props.put("mail.user", from);
        props.put("mail.password", pass);
        props.put("mail.port", "25");

        // Authorized the Session object.
        Session mailSession = Session.getInstance(props, new javax.mail.Authenticator() {
            @Override
            protected PasswordAuthentication getPasswordAuthentication() {
                return new PasswordAuthentication(from, pass);
            }
        });

        try {
            // Create a default MimeMessage object.
            MimeMessage message = new MimeMessage(mailSession);
            // Set From: header field of the header.
            message.setFrom(new InternetAddress(from));
            // Set To: header field of the header.
            message.addRecipient(Message.RecipientType.TO,
                    new InternetAddress(toMail));
            // Set Subject: header field
            message.setSubject(subject);
            // Now set the actual message
            message.setText(toMessage);
            // Send message
            Transport.send(message);
            result = "mail sent successfully from UCSY SIS....";
        } catch (MessagingException mex) {
            //ln("Enable to send email: " + mex);
            return false;
        }
        return true;
    }
    
    public String getSubjectMajorField(String s) {
		String fieldname = (s.equals("CS (BIS)")) ? "bis"
				: (s.equals("CS (SE)")) ? "se"
						: (s.equals("CS (KE)")) ? "KE"
								: (s.equals("CS (CSF)")) ? "csf" : (s.equals("CT (Networking)")) ? "nt" : "emb";
		return fieldname;
	}

	public String getTodayDate() {
		Date d = new Date();
		String st = "";
		int y = d.getYear() + 1900;
		int m = d.getMonth() + 1;
		int w = d.getDate();
		st = "" + y;
		if (m < 10) {
			st += "-0" + m;
		} else {
			st += "-" + m;
		}
		if (w < 10) {
			st += "-0" + w;
		} else {
			st += "-" + w;
		}
		return st;
	}

	public String getTodayTime() {
		Date d = new Date();
		String st = "";
		int y = d.getHours();
		int m = d.getMinutes();
		int w = d.getSeconds();
		if (y < 10) {
			st += "0" + y;
		} else {
			st += "" + y;
		}
		if (m < 10) {
			st += ":0" + m;
		} else {
			st += ":" + m;
		}
		if (w < 10) {
			st += ":0" + w;
		} else {
			st += ":" + w;
		}
		return st;
	}

	public String getTodayDateFormat() {
		Date d = new Date();
		String mm[] = new String[] { "Jan", "Feb", "Mar", "Apr", "May", "Jun", "Jul", "Aug", "Sep", "Oct", "Nov",
				"Dec" };
		String st = "";
		int y = d.getYear() + 1900;
		int m = d.getMonth();
		int w = d.getDate();
		st = mm[m] + " " + w + ", " + y;

		return st;
	}

	public String getTodayTimeFormat() {
		Date d = new Date();
		String st = "";
		int y = d.getHours();
		int m = d.getMinutes();
		int w = d.getSeconds();
		if (y < 10) {
			st += "0" + y;
		} else {
			st += "" + y;
		}
		if (m < 10) {
			st += ":0" + m;
		} else {
			st += ":" + m;
		}
		if (w < 10) {
			st += ":0" + w;
		} else {
			st += ":" + w;
		}
		return st;
	}

	public String getLetterGrade(double g) {
		String grade = "Z";
		if (g >= 90) {
			grade = "A";
		} else if (g >= 85 && g <= 89) {
			grade = "A-";
		} else if (g >= 80 && g <= 84) {
			grade = "B+";
		} else if (g >= 75 && g <= 79) {
			grade = "B";
		} else if (g >= 70 && g <= 74) {
			grade = "B-";
		} else if (g >= 65 && g <= 69) {
			grade = "C+";
		} else if (g >= 60 && g <= 64) {
			grade = "C";
		} else if (g >= 55 && g <= 59) {
			grade = "C-";
		} else if (g >= 50 && g <= 54) {
			grade = "D";
		} else if (g <= 50) {
			grade = "F";
		}
		return grade;
	}

	public double getGradeScore(double g) {
		double grade = 0.0;
		if (g >= 90) {
			grade = 4.0;
		} else if (g >= 85 && g <= 89) {
			grade = 3.75;
		} else if (g >= 80 && g <= 84) {
			grade = 3.25;
		} else if (g >= 75 && g <= 79) {
			grade = 3.0;
		} else if (g >= 70 && g <= 74) {
			grade = 2.75;
		} else if (g >= 65 && g <= 69) {
			grade = 2.25;
		} else if (g >= 60 && g <= 64) {
			grade = 2.0;
		} else if (g >= 55 && g <= 59) {
			grade = 1.75;
		} else if (g >= 50 && g <= 54) {
			grade = 1.0;
		} else if (g <= 50) {
			grade = 0.0;
		}
		return grade;
	}

	public String getCodeForMark(int m) {
		String slist[] = new String[] { "j", "p", "t", "r", "b", "l", "n", "d", "h", "f" };
		String retval = "";
		if (m == 100) {
			retval = "ss";
		} else if (m < 0) {
			retval = "aa";
		} else if (m >= 0 && m <= 9) {
			retval = "j" + slist[m];
		} else {
			int m1 = m / 10;
			int m2 = m % 10;
			retval = slist[m1] + slist[m2];
		}
		// System.out.println("\n\n" + retval + "\n\n");
		return retval;
	}

	public String getMarkFromCode(String m) {
		String slist[] = new String[] { "j", "p", "t", "r", "b", "l", "n", "d", "h", "f" };
		java.util.Hashtable h = new java.util.Hashtable();
		for (int i = 0; i < slist.length; i++) {
			h.put(slist[i], i + "");
		}
		String retval = m;
		if (m.equals("aa")) {
			retval = "-1";
		} else if (m.equals("ss")) {
			retval = "100";
		} else if (m.length() == 2) {
			retval = h.get(m.substring(0, 1)).toString();
			retval += h.get(m.substring(1, 2)).toString();
			retval = Integer.parseInt(retval) + "";
		}
		// System.out.println(""+retval);
		return retval;
	}
	
	public String getSub(int bis, int csf, int ke, int se, int nt, int emb) {
        String st = "";
        if(bis!=2)st += "CS (BIS) [" + getSubType(bis) + "]\n <br>";
        if(csf!=2)st += "CS (CSF) [" + getSubType(csf) + "]\n <br>";
        if(ke!=2)st += "CS (KE) [" + getSubType(ke) + "]\n <br>";
        if(se!=2)st += "CS (SE) [" + getSubType(se) + "]\n <br>";
        if(nt!=2)st += "CT (Networking) [" + getSubType(nt) + "]\n <br>";
        if(emb!=2)st += "CT (Embedded) [" + getSubType(emb) + "]\n <br>";
        return st;
    }

    public String getSubType(int i) {
        if (i==0) {
            return "Major - Core";
        } else if (i==1) {
            return "Major - Elective";
        } else {
            return "None";
        }
    }
}