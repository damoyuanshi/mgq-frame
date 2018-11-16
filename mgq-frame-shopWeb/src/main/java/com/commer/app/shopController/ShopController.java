package com.commer.app.shopController;

import com.commer.app.entity.User;
import com.commer.app.user.UserService;
import org.apache.log4j.Logger;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;

@RestController 
@RequestMapping("/shop") 
public class ShopController {
	private static Logger logger = Logger.getLogger(ShopController.class);
	@Resource  
    private UserService userService;
	
	@GetMapping("")
    public ModelAndView login(HttpSession session) {
		return new ModelAndView("shop_home");
			
	}
	
	@GetMapping("/index")
    public ModelAndView ShowIndex() {
		return new ModelAndView("shop_home");
	}

	@RequestMapping("/getUserById")
	public Object getUserById() {
		User user = userService.selectByPrimaryKey(1);
		if(user!=null){
			System.out.println("user.getName():"+user.getUsername());
			logger.info("user.getAge():"+user.getUsername());
		}
		return user;
	}
}
