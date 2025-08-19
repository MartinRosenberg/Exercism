const keep = <A>(arr: A[], pred: (elem: A) => boolean) =>
    arr.reduce((acc: A[], curr: A) => pred(curr) ? [...acc, curr] : acc, [])

const discard = <A>(arr: A[], pred: (elem: A) => boolean) =>
    arr.reduce((acc: A[], curr: A) => !pred(curr) ? [...acc, curr] : acc, [])

export { keep, discard }
