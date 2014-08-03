package cn.macrotea.showcase.web.controller;

import cn.macrotea.showcase.dao.UserDao;
import cn.macrotea.showcase.dto.ActionEnum;
import cn.macrotea.showcase.dto.DomainAndAction;
import cn.macrotea.showcase.model.User;
import org.apache.commons.lang3.RandomStringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import org.springframework.web.servlet.support.RequestContextUtils;

import javax.servlet.http.HttpServletRequest;
import java.util.Date;
import java.util.List;
import java.util.Map;

/**
 * @author macrotea@qq.com
 * @since 2014-7-28 上午8:33
 */
@Controller
@RequestMapping("/user")
public class UserController {
    private Logger logger = LoggerFactory.getLogger(this.getClass());
    public static final String DOMAIN = "user";

    public static final String DOMAIN_DESC = "用户";
    public static final String DATA_LIST = "dataList";
    public static final String ACTION_FLAG = "actionFlag";
    public static final String VIEW_USER_EDITOR = String.format("%s/%sEditor", DOMAIN, DOMAIN);
    public static final String VIEW_USER_LIST = String.format("%s/%sList", DOMAIN, DOMAIN);
    public static final String REDIRECT_LIST = String.format("redirect:/%s/list", DOMAIN);

    @Autowired
    private UserDao userDao;

    private void addDomainAndAction(ModelAndView mav, ActionEnum actionEnum) {
        DomainAndAction daa = new DomainAndAction(DOMAIN, actionEnum.name().toLowerCase(), DOMAIN_DESC, actionEnum.getDesc());
        mav.addObject(DomainAndAction.KEY, daa);
    }

    @RequestMapping(value = "index", method = RequestMethod.GET)
    public String index() {
        return REDIRECT_LIST;
    }

    @RequestMapping(value = "create", method = RequestMethod.GET)
    public ModelAndView create(@ModelAttribute(value = "m") User m, ModelAndView mav) {

        //prepare
        m.setUsername(RandomStringUtils.randomAlphanumeric(10));
        m.setPassword(RandomStringUtils.randomAlphanumeric(6));
        m.setAge(Integer.parseInt(RandomStringUtils.randomNumeric(2)));
        m.setMoney(Double.parseDouble(RandomStringUtils.randomNumeric(4)));
        m.setEmail("macrotea.com");

        addDomainAndAction(mav, ActionEnum.CREATE);
        mav.setViewName(VIEW_USER_EDITOR);
        return mav;
    }

    @RequestMapping(value = "create", method = RequestMethod.POST)
    public ModelAndView saveCreate(@ModelAttribute(value = "m") User m, ModelAndView mav) {
        addDomainAndAction(mav, ActionEnum.CREATE);
        try {
            m.setAddTime(new Date());
            userDao.saveOrUpdate(m);
            mav.addObject(ACTION_FLAG, true);
        } catch (Exception e) {
            mav.addObject(ACTION_FLAG, false);
            logger.error("保存新增失败", e);
        }

        mav.setViewName(VIEW_USER_EDITOR);
        return mav;
    }

    @RequestMapping(value = "edit", method = RequestMethod.GET)
    public ModelAndView edit(@RequestParam("id") long id, ModelAndView mav) {
        addDomainAndAction(mav, ActionEnum.EDIT);
        User result = userDao.findById(id);
        mav.addObject("m", result);
        mav.setViewName(VIEW_USER_EDITOR);
        return mav;
    }

    @RequestMapping(value = "edit", method = RequestMethod.POST)
    public ModelAndView saveEdit(@ModelAttribute(value = "m") User m, ModelAndView mav) {
        addDomainAndAction(mav, ActionEnum.EDIT);
        try {
            User user = userDao.findById(m.getId());
            user.setUsername(m.getUsername());
            user.setPassword(m.getPassword());
            user.setEmail(m.getEmail());
            user.setAge(m.getAge());
            user.setMoney(m.getMoney());
            userDao.saveOrUpdate(user);
            mav.addObject(ACTION_FLAG, true);
        } catch (Exception e) {
            mav.addObject(ACTION_FLAG, false);
            logger.error("保存编辑失败", e);
        }

        mav.setViewName(VIEW_USER_EDITOR);
        return mav;
    }

    @RequestMapping(value = "delete/{id}", method = RequestMethod.GET)
    public String delete(@PathVariable("id") long id, RedirectAttributes redirectAttributes) {
        try {
            userDao.delete(userDao.findById(id));
            redirectAttributes.addFlashAttribute(ACTION_FLAG, true);
        } catch (Exception e) {
            redirectAttributes.addFlashAttribute(ACTION_FLAG, false);
            logger.error(String.format("根据 Id=%s 删除失败",id), e);
        }
        return REDIRECT_LIST;
    }

    @RequestMapping(value = "list", method = RequestMethod.GET)
    public ModelAndView list(ModelAndView mav, HttpServletRequest request) {
        addDomainAndAction(mav, ActionEnum.LIST);
        List<User> userList = userDao.findAll();
        mav.addObject(DATA_LIST, userList);

        initRedirectAttributes(mav,request);
        mav.setViewName(VIEW_USER_LIST);
        return mav;
    }

    private void initRedirectAttributes(ModelAndView mav, HttpServletRequest request) {
        Map<String, ?> flashAttrMap = RequestContextUtils.getInputFlashMap(request);
        if (flashAttrMap != null && flashAttrMap.size() > 0) {
            Boolean flag = (Boolean) flashAttrMap.get(ACTION_FLAG);
            mav.addObject(ACTION_FLAG, flag);
        }
    }

}
