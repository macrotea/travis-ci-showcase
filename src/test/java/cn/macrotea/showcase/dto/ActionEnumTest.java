package cn.macrotea.showcase.dto;

import org.junit.Test;

import static junit.framework.Assert.assertEquals;

/**
 * @author macrotea@qq.com
 * @since 2014-8-4 上午12:40
 */
public class ActionEnumTest {

    @Test
    public void testGetDesc_CREATE() throws Exception {
        assertEquals(ActionEnum.CREATE.getDesc(), "新增");
    }

    @Test
    public void testGetDesc_EDIT() throws Exception {
        assertEquals(ActionEnum.EDIT.getDesc(), "编辑");
    }
}
