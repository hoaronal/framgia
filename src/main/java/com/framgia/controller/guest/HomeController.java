package com.framgia.controller.guest;

import javax.servlet.http.HttpServletRequest;
import org.apache.commons.lang3.StringUtils;
import com.framgia.service.ChatworkService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("public")
public class HomeController {

    @Autowired
    private ChatworkService chatworkService;

    @Value("${chatwork.roomId}")
    private String chatworkRoomId;

    @GetMapping
    public String dashboard(Model model, HttpServletRequest request){
        chatworkService.sendMessage(chatworkRoomId,"https://www.facebook.com/undefendable/photos/a.112307692132971/2534478743249175/?type=3&theater");
        model.addAttribute("clientIP", getClientIP(request));
        return "guest/index";
    }
    
	public static String getClientIP(HttpServletRequest request) {
		if (request == null) {
			return null;
		}
		String ip = request.getHeader("true-client-ip");
		if (isValidIP(ip)) {
			return ip;
		}
		String xff = request.getHeader("X-Forwarded-For");
		ip = getClientIPFromXFF(xff);
		if (ip != null) {
			return ip;
		}
		ip = request.getHeader("Proxy-Client-IP");
		if (isValidIP(ip)) {
			return ip;
		}
		ip = request.getHeader("WL-Proxy-Client-IP");
		if (isValidIP(ip)) {
			return ip;
		}
		ip = request.getRemoteAddr();
		return ip;
	}

	private static String getClientIPFromXFF(String xff) {
		if (StringUtils.isBlank(xff)) {
			return null;
		}
		String[] ss = xff.split(",");
		for (String ip : ss) {
			ip = ip.trim();
			if (isValidIP(ip)) {
				return ip;
			}
		}
		return null;
	}

	private static boolean isValidIP(String ip) {
		return !StringUtils.isEmpty(ip) && !"unknown".equalsIgnoreCase(ip);
	}
}
