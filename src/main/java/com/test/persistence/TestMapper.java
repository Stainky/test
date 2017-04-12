package com.test.persistence;

import com.test.domain.Test;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

/**
 * Created by sj on 17/4/12.
 */
@Repository("testMapper")
public interface TestMapper {
    public Test selectByPrimaryKey(@Param("id") Integer id);
}
