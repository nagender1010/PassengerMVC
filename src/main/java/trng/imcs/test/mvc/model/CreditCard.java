package trng.imcs.test.mvc.model;

import java.io.Serializable;

public class CreditCard implements Serializable {

	/**
	 * @author nagenender
	 */
	private static final long serialVersionUID = 6245850299870632583L;
	private Integer profileId;
	private String cardNumber;
	private String cardType;
	private String expMonth;
	private int expYear;

	public CreditCard() {
		super();
	}

	public CreditCard(Integer profileId, String cardNumber, String cardType, String expMonth, int expYear) {
		super();
		this.profileId = profileId;
		this.cardNumber = cardNumber;
		this.cardType = cardType;
		this.expMonth = expMonth;
		this.expYear = expYear;
	}

	public CreditCard(String cardNumber, String cardType, String expMonth, int expYear) {
		super();
		this.cardNumber = cardNumber;
		this.cardType = cardType;
		this.expMonth = expMonth;
		this.expYear = expYear;
	}

	@Override
	public String toString() {
		return "CreditCard [profileId=" + profileId + ", cardNumber=" + cardNumber + ", cardType=" + cardType
				+ ", expMonth=" + expMonth + ", expYear=" + expYear + "]";
	}

	public Integer getProfileId() {
		return profileId;
	}

	public void setProfileId(Integer profileId) {
		this.profileId = profileId;
	}

	public String getCardNumber() {
		return cardNumber;
	}

	public void setCardNumber(String cardNumber) {
		this.cardNumber = cardNumber;
	}

	public String getCardType() {
		return cardType;
	}

	public void setCardType(String cardType) {
		this.cardType = cardType;
	}

	public String getExpMonth() {
		return expMonth;
	}

	public void setExpMonth(String expMonth) {
		this.expMonth = expMonth;
	}

	public int getExpYear() {
		return expYear;
	}

	public void setExpYear(int expYear) {
		this.expYear = expYear;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((cardNumber == null) ? 0 : cardNumber.hashCode());
		result = prime * result + ((cardType == null) ? 0 : cardType.hashCode());
		result = prime * result + ((expMonth == null) ? 0 : expMonth.hashCode());
		result = prime * result + expYear;
		result = prime * result + ((profileId == null) ? 0 : profileId.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		CreditCard other = (CreditCard) obj;
		if (cardNumber == null) {
			if (other.cardNumber != null)
				return false;
		} else if (!cardNumber.equals(other.cardNumber))
			return false;
		if (cardType == null) {
			if (other.cardType != null)
				return false;
		} else if (!cardType.equals(other.cardType))
			return false;
		if (expMonth == null) {
			if (other.expMonth != null)
				return false;
		} else if (!expMonth.equals(other.expMonth))
			return false;
		if (expYear != other.expYear)
			return false;
		if (profileId == null) {
			if (other.profileId != null)
				return false;
		} else if (!profileId.equals(other.profileId))
			return false;
		return true;
	}

}
