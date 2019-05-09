#本项目适用于某公司mybatis架构用于自动生成mapper文件  
#本项目为包含BaseService和BaseDao，若有需要请私信zg    
  
#使用方法：  
先根据数据库或者逆向工程工具生成实体类。然后调用MapperCreateUtil中的main方法。  
buildXML(Yuan.class, "cn.com.soyea.rrmp.org.dao.impl");  
第一个参数为实体类类型，第二个参数为mapper.xml的命名空间。     