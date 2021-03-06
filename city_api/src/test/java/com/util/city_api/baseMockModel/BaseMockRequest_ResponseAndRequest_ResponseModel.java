package com.util.city_api.baseMockModel;

import java.time.LocalDateTime;

import org.mockito.Mockito;

import com.util.city_api.entity.primary.User;
import com.util.city_api.entity.security.RefreshToken;
import com.util.city_api.product_core.request.createRequest.LoginRequest;
import com.util.city_api.product_core.request.createRequest.SignupRequest;
import com.util.city_api.product_core.request.createRequest.UserCreateRequest;
import com.util.city_api.product_core.response.SignupReponse;

public class BaseMockRequest_ResponseAndRequest_ResponseModel {

	   // request model
	   public SignupRequest getSignupRequestModel() { 
			return new SignupRequest("username","email@email","password","");
	   }
		
	   public UserCreateRequest getUserCreateRequest(){
			return new UserCreateRequest("username","email@email","password"); 
	   }
		
	   public String confirmationTokenRequest() {
		   return "confirmationTokenRequest";
	   }
		
	   public LoginRequest getLoginRequestModel() {
		   return new LoginRequest(
				   "userName",
				   "email",
				   "password"
				   );
	   }
	   
	   public LoginRequest getMockLoginRequestModel() {
		   return Mockito.mock(LoginRequest.class);
	   }
	   
		
	    // response model
		public SignupReponse getSignupResponse() { 
			return new SignupReponse(
					"username",
					"email",
					"accessToken",
					"refreshToken",
					"expireTimeAccessToken",
					"expireTimeRefreshToken");
		}
		
		public SignupReponse getMockSignupResponse() {
			return Mockito.mock(SignupReponse.class);
		}
		
		public RefreshToken getRefreshToken(User user, LocalDateTime expiryDateTime, LocalDateTime createdDateTime  ) {
			return new RefreshToken("refreshTokenId",user,"refreshToken",expiryDateTime,createdDateTime);
		}
		
		public RefreshToken getMockRefreshToken() {
			return Mockito.mock(RefreshToken.class);
		}
		
		
		public String getAccessToken() {
			return "accessToken";
		}
		
		public String getMockAccessToken() {
			return Mockito.mock(String.class);
		}
		
		
		// constructor
		private static BaseMockRequest_ResponseAndRequest_ResponseModel _requestAndResponseModel;

		private BaseMockRequest_ResponseAndRequest_ResponseModel() {}
		
		public static BaseMockRequest_ResponseAndRequest_ResponseModel getInstance() {
			
			if(_requestAndResponseModel==null)
			{
				_requestAndResponseModel = new BaseMockRequest_ResponseAndRequest_ResponseModel();
			}
			return _requestAndResponseModel;
		}
}
