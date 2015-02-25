/*
 * Copyright (c) 2014 Robert Blust (Zurich, Switzerland) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * Contributors:
 *    Robert Blust - initial API and implementation
 */
package ch.flatland.cdo.util

import java.text.SimpleDateFormat
import java.util.Date
import java.util.TimeZone
import org.slf4j.LoggerFactory

class DateConverter {
	val logger = LoggerFactory.getLogger(this.class)

	val public static PATTERN_DATE = "[0-9]{4}-(([1]([0|1|2]))|([0][1-9]))-(([3]([0|1]))|(([0])[1-9])|(([1]|[2])[0-9]))"
	val public static PATTERN_TIME = "([0-1][0-9]|[2][0-3]):([0-5][0-9])"
	val public static PATTERN_SECOND = "([0-5][0-9])"
	val public static PATTERN_MILLISECONDS = "[0-9][0-9][0-9]"
	val public static PATTERN_DATE_ALL = '''«PATTERN_DATE»(T«PATTERN_TIME»(:«PATTERN_SECOND»(.«PATTERN_MILLISECONDS»)?)?Z)?'''
	val public static PATTERN_DATE_TIME = '''«PATTERN_DATE»T«PATTERN_TIME»Z'''
	val public static PATTERN_DATE_TIME_SECOND = '''«PATTERN_DATE»T«PATTERN_TIME»:«PATTERN_SECOND»Z'''
	val public static PATTERN_DATE_TIME_SECOND_MILLISECOND = '''«PATTERN_DATE»T«PATTERN_TIME»:«PATTERN_SECOND».«PATTERN_MILLISECONDS»Z'''

	val public static FORMAT_DATE = "yyyy-MM-dd"
	val public static FORMAT_DATE_TIME = "yyyy-MM-dd'T'HH:mm'Z'"
	val public static FORMAT_DATE_TIME_SECOND = "yyyy-MM-dd'T'HH:mm:ss'Z'"
	val public static FORMAT_DATE_TIME_MILLISECOND = "yyyy-MM-dd'T'HH:mm:ss.SSS'Z'"

	def getSimpleDateFormat(String dateString) {
		var SimpleDateFormat dateFormat

		if(dateString.matches(PATTERN_DATE)) {
			dateFormat = new SimpleDateFormat(FORMAT_DATE)
		} else if(dateString.matches(PATTERN_DATE_TIME)) {
			dateFormat = new SimpleDateFormat(FORMAT_DATE_TIME)
		} else if(dateString.matches(PATTERN_DATE_TIME_SECOND)) {
			dateFormat = new SimpleDateFormat(FORMAT_DATE_TIME_SECOND)
		} else if(dateString.matches(PATTERN_DATE_TIME_SECOND_MILLISECOND)) {
			dateFormat = new SimpleDateFormat(FORMAT_DATE_TIME_MILLISECOND)
		} else {
			dateFormat = new SimpleDateFormat(FORMAT_DATE_TIME_MILLISECOND)
		}

		dateFormat.timeZone = TimeZone.getTimeZone("Zulu")
		return dateFormat
	}

	def parseDate(String dateString) {
		logger.debug("Parse date '{}'", dateString)
		dateString.simpleDateFormat.parse(dateString)
	}

	def formatDate(Date date) {
		logger.debug("Format date '{}'", date)
		"all".simpleDateFormat.format(date)
	}
}
