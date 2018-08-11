package com.jinlong.system.common.utils.exception;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.TimeoutException;

import javax.el.MethodNotFoundException;

import org.springframework.dao.CleanupFailureDataAccessException;
import org.springframework.dao.DataAccessResourceFailureException;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.dao.DataRetrievalFailureException;
import org.springframework.dao.DeadlockLoserDataAccessException;
import org.springframework.dao.IncorrectUpdateSemanticsDataAccessException;
import org.springframework.dao.InvalidDataAccessApiUsageException;
import org.springframework.dao.InvalidDataAccessResourceUsageException;
import org.springframework.dao.OptimisticLockingFailureException;
import org.springframework.dao.TypeMismatchDataAccessException;
import org.springframework.dao.UncategorizedDataAccessException;

import net.rubyeye.xmemcached.exception.MemcachedException;

/**
 * 日志记录信息
 * @author 肖学进
 */
public class LogicExceptionMessage {
	
	public static Map<String, String> logic_exception_map = new HashMap<String, String>();

	/**
	 * 初始化数据
	 */
	static {
		logic_exception_map.put(LogicExceptionNumber.CleanupFailureDataAccessException, "一项操作成功地执行，但在释放数据库资源时发生异常");
		logic_exception_map.put(LogicExceptionNumber.DataAccessResourceFailureException, "数据访问资源彻底失败，例如不能连接数据库");
		logic_exception_map.put(LogicExceptionNumber.DataIntegrityViolationException, "一项操作成功地执行，但在释放数据库资源时发生异常");
		logic_exception_map.put(LogicExceptionNumber.DataRetrievalFailureException, "某些数据不能被检测到");
		logic_exception_map.put(LogicExceptionNumber.DeadlockLoserDataAccessException, " 当前的操作因为死锁而失败");
		logic_exception_map.put(LogicExceptionNumber.IncorrectUpdateSemanticsDataAccessException, "Update时发生某些没有预料到的情况");
		logic_exception_map.put(LogicExceptionNumber.InvalidDataAccessApiusageException, "一个数据访问的JAVA API没有正确使用");
		logic_exception_map.put(LogicExceptionNumber.InvalidDataAccessResourceUsageException, "错误使用数据访问资源，例如用错误的SQL语法访问关系型数据库");
		logic_exception_map.put(LogicExceptionNumber.OptimisticLockingFailureException, "乐观锁的失败。这将由ORM工具或用户的DAO实现抛出");
		logic_exception_map.put(LogicExceptionNumber.TypeMismatchDataAccessException, "Java类型和数据类型不匹配，例如试图把String类型插入到数据库的数值型字段中");
		logic_exception_map.put(LogicExceptionNumber.UncategorizedDataAccessException, "错误使用数据访问资源");
		logic_exception_map.put(LogicExceptionNumber.PARAMETER_ARITHMETIC_EXCEPTION, "算数计算异常");
		logic_exception_map.put(LogicExceptionNumber.PARAMETER_NULL_POINTER_EXCEPTION, "参数为空，空指针异常");
		logic_exception_map.put(LogicExceptionNumber.PARAMETER_ARRAY_INDEX_OUT_OF_BOUNDS_EXCEPTION, "数组越界异常");
		logic_exception_map.put(LogicExceptionNumber.PARAMETER_CLASS_NOT_FOUND_EXCEPTION, "class类找不到异常");
		logic_exception_map.put(LogicExceptionNumber.PARAMENTER_METHOD_NOT_FOUND_EXCEPTION, "method方法找不到异常");
		logic_exception_map.put(LogicExceptionNumber.PARAMETER_FILE_NOT_FOUND_EXCEPTION, "文件找不到异常");
		logic_exception_map.put(LogicExceptionNumber.PARAMETER_IO_EXCEPTION, "IO流异常");
	}
	
	/**
	 * @description 通过异常，来判断异常类型，返回异常信息
	 * @param e
	 * @return
	 */
	public static String returnExceptionMessage(Exception e) {
		if (e instanceof CleanupFailureDataAccessException) {
			return logic_exception_map.get(LogicExceptionNumber.CleanupFailureDataAccessException);
		}
		if (e instanceof DataAccessResourceFailureException) {
			return logic_exception_map.get(LogicExceptionNumber.DataAccessResourceFailureException);
		}
		if (e instanceof DataIntegrityViolationException) {
			return logic_exception_map.get(LogicExceptionNumber.DataIntegrityViolationException);
		}
		if (e instanceof DataRetrievalFailureException) {
			return logic_exception_map.get(LogicExceptionNumber.DataRetrievalFailureException);
		}
		if (e instanceof DeadlockLoserDataAccessException) {
			return logic_exception_map.get(LogicExceptionNumber.DeadlockLoserDataAccessException);
		}
		if (e instanceof IncorrectUpdateSemanticsDataAccessException) {
			return logic_exception_map.get(LogicExceptionNumber.IncorrectUpdateSemanticsDataAccessException);
		}
		if (e instanceof InvalidDataAccessApiUsageException) {
			return logic_exception_map.get(LogicExceptionNumber.InvalidDataAccessApiusageException);
		}
		if (e instanceof InvalidDataAccessResourceUsageException) {
			return logic_exception_map.get(LogicExceptionNumber.InvalidDataAccessResourceUsageException);
		}
		if (e instanceof OptimisticLockingFailureException) {
			return logic_exception_map.get(LogicExceptionNumber.OptimisticLockingFailureException);
		}
		if (e instanceof TypeMismatchDataAccessException) {
			return logic_exception_map.get(LogicExceptionNumber.TypeMismatchDataAccessException);
		}
		if (e instanceof UncategorizedDataAccessException) {
			return logic_exception_map.get(LogicExceptionNumber.UncategorizedDataAccessException);
		}
		if (e instanceof ArithmeticException) {
			return logic_exception_map.get(LogicExceptionNumber.PARAMETER_ARITHMETIC_EXCEPTION);
		}
		if (e instanceof NullPointerException) {
			return logic_exception_map.get(LogicExceptionNumber.PARAMETER_NULL_POINTER_EXCEPTION);
		}
		if (e instanceof ArrayIndexOutOfBoundsException) {
			return logic_exception_map.get(LogicExceptionNumber.PARAMETER_ARRAY_INDEX_OUT_OF_BOUNDS_EXCEPTION);
		}
		if (e instanceof ClassNotFoundException) {
			return logic_exception_map.get(LogicExceptionNumber.PARAMETER_CLASS_NOT_FOUND_EXCEPTION);
		}
		if (e instanceof MethodNotFoundException) {	
			return logic_exception_map.get(LogicExceptionNumber.PARAMENTER_METHOD_NOT_FOUND_EXCEPTION);
		}
		if (e instanceof FileNotFoundException) {
			return logic_exception_map.get(LogicExceptionNumber.PARAMETER_FILE_NOT_FOUND_EXCEPTION);
		}
		if (e instanceof IOException) {
			return logic_exception_map.get(LogicExceptionNumber.PARAMETER_IO_EXCEPTION);
		}
		if (e instanceof TimeoutException) {
			return logic_exception_map.get(LogicExceptionNumber.TIMEOUT_EXCEPTION);
		}
		if (e instanceof InterruptedException) {
			return logic_exception_map.get(LogicExceptionNumber.INTERRUPTED_EXCEPTION);
		}
		if (e instanceof MemcachedException) {
			return logic_exception_map.get(LogicExceptionNumber.MEMCACHED_EXCEPTION);
		}
		return "otherException";
	}
	
	/**
	 * @生成自定义的日志记录异常
	 * @param exceptionPackage
	 * @param exceptionMethod
	 * @param e
	 * @return
	 */
	public static LogicException returnLogicException(String exceptionPackage, String exceptionMethod, Exception e) {
		return new LogicException(exceptionPackage, exceptionMethod, returnExceptionMessage(e));
	}
	
	/**
	 * @生成自定义的日志记录异常
	 * @param exceptionPackage
	 * @param exceptionMethod
	 * @param exceptionMessage
	 * @param e
	 * @return
	 */
	public static LogicException returnLogicException(String exceptionPackage, String exceptionMethod, String exceptionMessage, Exception e) {
		return new LogicException(exceptionPackage, exceptionMethod, exceptionMessage + returnExceptionMessage(e));
	}
	
	

}
