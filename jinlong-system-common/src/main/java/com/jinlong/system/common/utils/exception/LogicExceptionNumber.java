package com.jinlong.system.common.utils.exception;


/**
 * 错误码
 * @author 肖学进
 */
public final class LogicExceptionNumber {
    
    /*
     * 系统错误
     */
	
	/**
	 * 内存溢出错误
	 */
	public static final String PARAMETER_OUT_OF_MEMORRY_ERROR = "000000";
	
	/**
	 * 网络连接错误
	 */
	public static final String PARAMETER_NET_WORK_ERROE = "000000";
	
	/**
	 * 数据库连接错误
	 */
	public static final String PARAMETER_DATABASE_NET_ERROR = "000000";
    
    /*
     * Spring底层异常
     */
	
    /**
	 * 一项操作成功地执行，但在释放数据库资源时发生异常（例如，关闭一个Connection）
	 */
	public static final String CleanupFailureDataAccessException = "000001";
	
	/**
	 * 数据访问资源彻底失败，例如不能连接数据库
	 */
	public static final String DataAccessResourceFailureException = "000002";
	
	/**
	 * Insert或Update数据时违反了完整性，例如违反了惟一性限制
	 */
	public static final String DataIntegrityViolationException = "000003";
	
	/**
	 * 某些数据不能被检测到，例如不能通过关键字找到一条记录
	 */
	public static final String DataRetrievalFailureException = "000004";
	
	/**
	 * 当前的操作因为死锁而失败
	 */
	public static final String DeadlockLoserDataAccessException	= "000005";
	
	/**
	 * Update时发生某些没有预料到的情况，例如更改超过预期的记录数。当这个异常被抛出时，执行着的事务不会被回滚
	 */
	public static final String IncorrectUpdateSemanticsDataAccessException = "000006";
	
	/**
	 * 一个数据访问的JAVA API没有正确使用，例如必须在执行前编译好的查询编译失败了
	 */
	public static final String InvalidDataAccessApiusageException = "000007";
	
	/**
	 * 错误使用数据访问资源，例如用错误的SQL语法访问关系型数据库
	 */
	public static final String InvalidDataAccessResourceUsageException = "000008";
	
	/**
	 * 乐观锁的失败。这将由ORM工具或用户的DAO实现抛出
	 */
	public static final String OptimisticLockingFailureException = "000009";
	
	/**
	 * 错误使用数据访问资源，例如用错误的SQL语法访问关系型数据库
	 */
	public static final String TypeMismatchDataAccessException = "000010";
	
	/**
	 * 错误使用数据访问资源，例如用错误的SQL语法访问关系型数据库
	 */
	public static final String UncategorizedDataAccessException = "000011";
	
	/*
	 * 运行时异常
	 */
	
	/**
	 * 算数计算异常
	 */
	public static final String PARAMETER_ARITHMETIC_EXCEPTION = "000012";
	
	/**
	 * 参数为空，空指针异常
	 */
	public static final String PARAMETER_NULL_POINTER_EXCEPTION = "000013";
	
	/**
	 * 数组越界异常
	 */
	public static final String PARAMETER_ARRAY_INDEX_OUT_OF_BOUNDS_EXCEPTION = "000014";
	
	/**
	 * class类找不到异常
	 */
	public static final String PARAMETER_CLASS_NOT_FOUND_EXCEPTION = "000015";
	
	/**
	 * method方法找不到异常
	 */
	public static final String PARAMENTER_METHOD_NOT_FOUND_EXCEPTION = "000016";
	
    
    /*
     * 非运行时异常
     */
    
	/**
	 * 文件找不到异常
	 */
	public static final String PARAMETER_FILE_NOT_FOUND_EXCEPTION = "000017";
	
	/**
	 * IO流异常
	 */
	public static final String PARAMETER_IO_EXCEPTION = "0000018";
	
	
	
	/*
	 * Memcached底层的异常
	 */
	
	/**
	 * 配置超时异常
	 */
	public static final String TIMEOUT_EXCEPTION = "0019";
	
	/**
	 * 线程被打断异常
	 */
	public static final String INTERRUPTED_EXCEPTION = "0020";
	
	/**
	 * Memcached异常
	 */
	public static final String MEMCACHED_EXCEPTION = "0021";
    
}