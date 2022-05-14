package Bean;

import javax.faces.application.FacesMessage;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.validator.FacesValidator;
import javax.faces.validator.Validator;
import javax.faces.validator.ValidatorException;


@FacesValidator("jsf.passwordValidator")
public class passwordValidator implements Validator {

	@Override
	public void validate(FacesContext context, UIComponent component, Object obj)
			throws ValidatorException {
		// TODO Auto-generated method stub
		String password = (String) obj;
	    if(password.length()<=8)
	    		{FacesMessage message = new FacesMessage(
	    		FacesMessage.SEVERITY_ERROR, 
	    		"密码长度错误", 
	    		"密码应大于8位"); 
	    		throw new ValidatorException(message); 
}
	 
boolean isLetter=false;//验证字母
boolean isDigit=false;//验证数字
for(int i=0;i<password.length();i++)
{
if(Character.isDigit(password.charAt(i)))
{isDigit=true;}
if(Character.isLetter(password.charAt(i)))
{isLetter=true;}
}
	   if(isDigit!=true||isLetter!=true)
	   {
		   FacesMessage message = new FacesMessage(
		    		FacesMessage.SEVERITY_ERROR, 
		    		"验证错误", 
		    		"密码应是数字和字母的组合"); 
		    		throw new ValidatorException(message); 
		   
	   }
	    
	    
	    
	}

}
