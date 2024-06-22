package com.geekaca.mall.geekmall.mapper;

import com.geekaca.mall.geekmall.domain.MallIndexConfig;
import com.geekaca.mall.geekmall.utils.PageQueryUtil;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
* @author ytdag
* @description 针对表【tb_newbee_mall_index_config】的数据库操作Mapper
* @createDate 2023-07-14 20:17:03
* @Entity com.geekaca.mall.geekmall.domain.MallIndexConfig
*/
public interface MallIndexConfigMapper {

    int deleteByPrimaryKey(Long id);

    int insert(MallIndexConfig record);

    int insertSelective(MallIndexConfig record);

    MallIndexConfig selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(MallIndexConfig record);

    int updateByPrimaryKey(MallIndexConfig record);

    List<MallIndexConfig> findIndexConfigList(PageQueryUtil pageUtil);

    int getTotalIndexConfigs(PageQueryUtil pageUtil);

    MallIndexConfig selectByTypeAndGoodsId(@Param("configType") int configType, @Param("goodsId") Long goodsId);;

    int deleteBatch(Long[] ids);
}
