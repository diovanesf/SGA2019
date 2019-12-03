export function parseDate(input) {
  var date = input.split("T")[0];
  var parts = date.split("-");
  return new Date(parts[0], parts[1] - 1, parts[2]);
}
