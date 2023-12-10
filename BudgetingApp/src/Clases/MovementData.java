package Clases;

import java.math.BigDecimal;
import java.util.Date;

public class MovementData {
	
    private String name;
    private String lastName;
    private String email;
    private int userId;
    private int accountId;
    private String accountName;
    private int accountType;
    private String accountTypeName;
    private BigDecimal accountBalance;
    private int movementId;
    private BigDecimal movementAmount;
    private int actionId;
    private String actionName;
    private Date movementDate;
    
    
	public MovementData() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
	public MovementData(String name, String lastName, String email, int userId, int accountId, String accountName,
			int accountType, String accountTypeName, BigDecimal accountBalance, int movementId,
			BigDecimal movementAmount, int actionId, String actionName, Date movementDate) {
		super();
		this.name = name;
		this.lastName = lastName;
		this.email = email;
		this.userId = userId;
		this.accountId = accountId;
		this.accountName = accountName;
		this.accountType = accountType;
		this.accountTypeName = accountTypeName;
		this.accountBalance = accountBalance;
		this.movementId = movementId;
		this.movementAmount = movementAmount;
		this.actionId = actionId;
		this.actionName = actionName;
		this.movementDate = movementDate;
	}


	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public int getUserId() {
		return userId;
	}
	public void setUserId(int userId) {
		this.userId = userId;
	}
	public int getAccountId() {
		return accountId;
	}
	public void setAccountId(int accountId) {
		this.accountId = accountId;
	}
	public String getAccountName() {
		return accountName;
	}
	public void setAccountName(String accountName) {
		this.accountName = accountName;
	}
	public int getAccountType() {
		return accountType;
	}
	public void setAccountType(int accountType) {
		this.accountType = accountType;
	}
	public String getAccountTypeName() {
		return accountTypeName;
	}
	public void setAccountTypeName(String accountTypeName) {
		this.accountTypeName = accountTypeName;
	}
	public BigDecimal getAccountBalance() {
		return accountBalance;
	}
	public void setAccountBalance(BigDecimal accountBalance) {
		this.accountBalance = accountBalance;
	}
	public int getMovementId() {
		return movementId;
	}
	public void setMovementId(int movementId) {
		this.movementId = movementId;
	}
	public BigDecimal getMovementAmount() {
		return movementAmount;
	}
	public void setMovementAmount(BigDecimal movementAmount) {
		this.movementAmount = movementAmount;
	}
	public int getActionId() {
		return actionId;
	}
	public void setActionId(int actionId) {
		this.actionId = actionId;
	}
	public String getActionName() {
		return actionName;
	}
	public void setActionName(String actionName) {
		this.actionName = actionName;
	}
	public Date getMovementDate() {
		return movementDate;
	}
	public void setMovementDate(Date movementDate) {
		this.movementDate = movementDate;
	}
	@Override
	public String toString() {
		return "MovementData [name=" + name + ", lastName=" + lastName + ", email=" + email + ", userId=" + userId
				+ ", accountId=" + accountId + ", accountName=" + accountName + ", accountType=" + accountType
				+ ", accountTypeName=" + accountTypeName + ", accountBalance=" + accountBalance + ", movementId="
				+ movementId + ", movementAmount=" + movementAmount + ", actionId=" + actionId + ", actionName="
				+ actionName + ", movementDate=" + movementDate + "]";
	}
    
    

}
