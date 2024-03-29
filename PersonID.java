package hw2;
import static hw2.ConstantValues.*;

public class PersonID {
	
	private String birthDate = NO_BIRTHDATE;
	
	public String getBirthDate() {
		return birthDate;
	}
	
	public String setPersonID(final String personID) {		
		
		if (checkPersonIDNumber(personID)) { 
			char centuryCharacter = personID.charAt(6);
			int vuosisata = 0;
			
			if (centuryCharacter == '-') {
				vuosisata = 19;
			} else if (centuryCharacter == '+') {
				vuosisata = 18;
			} else if (centuryCharacter == 'A') {
				vuosisata = 20;
			}
			int paiva = Integer.parseInt(personID.substring(0, 2));
			int kk = Integer.parseInt(personID.substring(2, 4));
			int vuosi = vuosisata * 100 + Integer.parseInt(personID.substring(4, 6));
			String birthdate = String.format("%02d.%02d.%04d", paiva, kk, vuosi);
			
			if (checkBirtdate(birthdate)) {
				if (checkValidCharacter(personID)) {
					this.birthDate = birthdate;
					return "Ok";
				}
				else {
					return "Incorrect check mark!";
				}
			}
			else {
				return "Invalid birthday!";
			}		
		}
		else {
			return "Invalid birthday!";
		}
	}
	private boolean checkPersonIDNumber(final String personID) {
		
		if (personID.length() == 11) {
			char centuryCharacter = personID.charAt(6);
			if (centuryCharacter == '+' || centuryCharacter == '-' || centuryCharacter == 'A'){
				return true;
			}
			else
				return false;
		}
		else
			return false;
	}
	private boolean checkLeapYear(int year) {
		 return (year % 4 == 0) && (year % 100 != 0 || year % 400 == 0);
	}
	private boolean checkValidCharacter(final String personID) {
		String oikeatMerkit = "0123456789ABCDEFHJKLMNPRSTUVWXY";
		
		String jaettava = personID.replaceAll("\\D", "");
		int numero = Integer.parseInt(jaettava);
		//System.out.println(Integer.toString(numero));
		int jakojaannos = numero % 31;
		//System.out.println(Integer.toString(jakojaannos));
		//System.out.println(oikeatMerkit.charAt(jakojaannos));
		//System.out.println(personID.charAt(10));
		return (personID.charAt(10) == oikeatMerkit.charAt(jakojaannos));			
	}
	private boolean checkBirtdate(final String date) {
		String[] osat = date.split("\\.");
		int paiva = Integer.parseInt(osat[0]);
		int kk = Integer.parseInt(osat[1]);
		int vuosi = Integer.parseInt(osat[2]);
		
		if (vuosi <= 0) {
			return false;
		}
		if (kk < 1 || kk > 12) {
			return false;
		}
		if (kk == 2) {
	            if (checkLeapYear(vuosi)) {
	                if (paiva < 1 || paiva > 29) {
	                    return false;
	                }
	            } 
	            else {
	                if (paiva < 1 || paiva > 28) {
	                    return false;
	                }
	            }
		} 
		else if (kk == 4 || kk == 6 || kk == 9 || kk == 11) {
	            if (paiva < 1 || paiva > 30) {
	                return false;
	            }
	            } 
	     		else {
	     			if (paiva < 1 || paiva > 31) {
	     				return false;
	            }
	        }
	        return true;
	    }
	
}
