export function formatPrice(amount) {
  if (amount === null || amount === undefined) return '۰';
  return amount
    .toString()
    .replace(/\B(?=(\d{3})+(?!\d))/g, ',');
}