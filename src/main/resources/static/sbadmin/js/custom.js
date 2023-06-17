function subtractOneDay(isoDateString) {
  var date = new Date(isoDateString);
  date.setDate(date.getDate() - 1);

  var year = date.getFullYear();
  var month = ("0" + (date.getMonth() + 1)).slice(-2);
  var day = ("0" + date.getDate()).slice(-2);
  var formattedDate = `${year}-${month}-${day}`;
  return formattedDate;
}

//첫번째 파라미터 기준 월, 두 번째 파라미터 더하거나 뺄 월)month)
function addMonthsToDate(dateStr, monthsToAdd) {
  monthsToAdd = (monthsToAdd == null) ? 0 : monthsToAdd;
  var date = new Date(dateStr);
  date.setMonth(date.getMonth() + monthsToAdd);

  var year = date.getFullYear();
  var month = date.getMonth() + 1;
  var day = date.getDate();

  // 월과 일이 한 자리 숫자인 경우 앞에 0을 추가해줍니다.
  if (month < 10) {
    month = '0' + month;
  }
  if (day < 10) {
    day = '0' + day;
  }

  return year + '-' + month + '-' + day;
}

function dateToYYYYMMString(date){
    var year = date.getFullYear();
    var month = date.getMonth() + 1;

    // 월이 한 자리 숫자인 경우 앞에 0을 추가해줍니다.
    if (month < 10) {
      month = '0' + month;
    }

    return year + '-' + month;
}

