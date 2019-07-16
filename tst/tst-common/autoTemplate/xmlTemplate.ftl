<?xml version="1.0" encoding="UTF-8" ?>
<!DOCTYPE mapper PUBLIC "-//mybatis.org//DTD Mapper 3.0//EN" 
"http://mybatis.org/dtd/mybatis-3-mapper.dtd">
<mapper namespace="tst.project.dao.controller.${className?cap_first}DaoC">

	<select id="get${className?cap_first}s" parameterType="${className}Bean" resultType="${className}Bean">
		select * from tst_${className}
		where is_delete='0'
		<#list columnMap?keys as key>
		<if test=' ${key} != null and ${key} != "" '>
			 and ${key}=${key}
		</if>
		</#list>
	</select>
	<select id="get${className?cap_first}" parameterType="${className}Bean" resultType="${className}Bean">
		select * from tst_${className}
		where is_delete='0' 
		and ${className}_id = ${className}_id
	</select>
	<update id="update${className?cap_first}" parameterType="${className}Bean">
		update tst_${className}
		set update_time=now()
		<#list columnMap?keys as key>
		<if test=' ${key} != null and ${key} != "" '>
			 ,${key}=${key}
		</if>
		</#list>
		
		where ${className}_id=${className}_id
	</update>
	<insert id="insert${className?cap_first}" parameterType="${className}Bean">
		
		insert into 
		tst_${className}(<#list columnMap?keys as key>${key},</#list>)
		values(
		<#list columnMap?keys as key>
		${key},
		</#list>
		now(),now())
	</insert>
	<update id="delete${className?cap_first}" parameterType="${className}Bean">
		update tst_${className} set update_time = now()
		,is_delete = 1
		where ${className}_id = ${className}_id
	</update>

</mapper>
