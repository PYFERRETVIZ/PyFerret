# fname is the list of html files that have anchors. in the ../users-guide
# directory see the "anchor-refs" file written by get-anchors.jnl
# Get the number of times each anchor in full-index/index.html is found in the file
# In the resulting file out.out, edit , changing the line-break and "file_and_anchor"
# to a couple of spaces. Now,
#   grep "0  " out.out > missing_anchors.list
#   sort -u missing_anchors.list > missing_anchors.sort

# Run this from in the chapter directory

rm -f out.out
echo " " > out.out

foreach fname ( $flist )
  set glist = `cat $fname.anchors`
   foreach gname ($glist)
     grep -c $gname $fname >> out.out
     echo file_and_anchor $fname  $gname >> out.out
     echo " " >> out.out
   end
   echo $fname
   echo " "
   sleep 1
end
 