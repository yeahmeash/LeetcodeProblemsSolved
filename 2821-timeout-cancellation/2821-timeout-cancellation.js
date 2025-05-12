function cancellable(fn, args, t) {
  const timerId = setTimeout(() => fn(...args), t);
  return () => clearTimeout(timerId); // this is cancelFn
}
