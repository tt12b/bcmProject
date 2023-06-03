function subtractOneDay(isoDateString) {
  var date = new Date(isoDateString);
  date.setDate(date.getDate() - 1);

  var year = date.getFullYear();
  var month = ("0" + (date.getMonth() + 1)).slice(-2);
  var day = ("0" + date.getDate()).slice(-2);
  var formattedDate = `${year}-${month}-${day}`;
  return formattedDate;
}