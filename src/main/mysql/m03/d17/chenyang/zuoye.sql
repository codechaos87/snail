SELECT 
  bname,
  bid,
  author,
  pubcomp,
  price 
FROM
  book 
WHERE bid NOT IN 
  (SELECT 
    nif 
  FROM
    borrow `borrow` 
  WHERE returndate IS NOT NULL);
  SELECT 
    r.`rname`,
    b.`bname`,
    p.`pdate`,
    p.`amount`
  FROM
    reader r 
    INNER JOIN penalty p 
      ON r.`rid`=p.`rid` 
    INNER JOIN book b 
      ON p.`bid`=b.`bid`
     WHERE pdate >'2018';
     
SELECT 
  r.`rid`,
  r.`rname`,
  b.`bname`,
  br.`lenddate`,
  br.`willdate` 
FROM
  book b 
  INNER JOIN borrow br 
    ON b.`bid` = br.`nif` 
  INNER JOIN reader r 
    ON r.`rid` = br.`rid` 
WHERE r.`rid` IN 
  (SELECT 
    rid 
  FROM
    reader 
  WHERE raddress IS NULL) 
  AND br.`rid` IN 
  (SELECT 
    rid 
  FROM
    borrow 
  WHERE returndate IS NULL) 
ORDER BY r.`rid` DESC,
br.`lenddate` ASC ;

