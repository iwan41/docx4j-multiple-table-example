# docx4j-multiple-table-example
In this example project we have few key objectives:
1. we have to use our super/hyper docx template from our legal/report/whatever deparment,
1. we have many rows which do not fit on one page,
1. we need to repeat header on every page,
1. we have many collumns which do not fit on one page,
1. we need to generate another table starting from new page, if collumns do not fit on one page.

This solution:
1. reads docx file with docx4j,
1. finds template table, 
1. clears template,
1. splits data into portions that fits on one page,
1. generates every table with maximum of data,
1. starts new table on new page if there is more data to write,
1. at the end it is clearing possibly blank colls.

Dependencies:
- org.docx4j - docx4j
