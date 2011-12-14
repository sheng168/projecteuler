package learn

object P24 {

  def main(args: Array[String]): Unit = {
    var i = 0; (0 to 9).permutations.take(10000000).foreach(p=>{i+=1; if (i%10000==0) println(i, p.mkString)})
    return
    var test = 0
    var c = 0
    for (i <- 123456789 to Int.MaxValue) {
      test += 1
      val s = if (i < 1000000000) "0" + i.toString else i.toString
      
      if (s.length == s.toSet.size) {
        c+=1
        if (c % 10000 == 0) {
          println(new java.util.Date,s, c, test, test/c)
          if (c == 1000000) return
        }
      }
    }
      
  }

  /** For each element x in List xss, returns (x, xss - x) */
   def selections[A](xss:List[A]):List[(A,List[A])] = xss match {
      case Nil => Nil
      case x :: xs =>
         (x, xs) :: (for( (y, ys) <- selections (xs) )
            yield (y, x :: ys))
   }

   /** Returns a list containing all permutations of the input list */
   def permute[A](xs:List[A]):List[List[A]] = xs match {
      case Nil => List(Nil)

      //special case lists of length 1 and 2 for better performance
      case t :: Nil => List(xs)
      case t :: u :: Nil => List(xs,List(u,t))

      case _ => 
         for ( (y,ys) <- selections(xs); ps <- permute(ys))
            yield y :: ps
   }

}

/*
(Fri Sep 16 16:31:52 EDT 2011,0139846572,10000,16389784,1638)
(Fri Sep 16 16:25:43 EDT 2011,125308467,10000,1851679,185)
(Fri Sep 16 16:29:58 EDT 2011,125308467,10000,1851679,185)
(Fri Sep 16 16:30:01 EDT 2011,127098563,20000,3641775,182)
(Fri Sep 16 16:30:03 EDT 2011,129084563,30000,5627775,187)

(Fri Sep 16 16:13:46 EDT 2011,125308467,10000,1851679,185)
(Fri Sep 16 16:13:48 EDT 2011,127098563,20000,3641775,182)
(Fri Sep 16 16:13:50 EDT 2011,129084563,30000,5627775,187)
(Fri Sep 16 16:13:54 EDT 2011,132087456,40000,8630668,215)
(Fri Sep 16 16:13:57 EDT 2011,135079682,50000,11622894,232)
(Fri Sep 16 16:14:00 EDT 2011,137064582,60000,13607794,226)
(Fri Sep 16 16:14:02 EDT 2011,139057246,70000,15600458,222)
(Fri Sep 16 16:14:05 EDT 2011,142059783,80000,18602995,232)
(Fri Sep 16 16:14:09 EDT 2011,145036782,90000,21579994,239)
(Fri Sep 16 16:14:11 EDT 2011,147028356,100000,23571568,235)
(Fri Sep 16 16:14:14 EDT 2011,148976350,110000,25519562,231)
(Fri Sep 16 16:14:16 EDT 2011,150983462,120000,27526674,229)
(Fri Sep 16 16:14:19 EDT 2011,153976024,130000,30519236,234)
(Fri Sep 16 16:14:23 EDT 2011,156948370,140000,33491582,239)
(Fri Sep 16 16:14:25 EDT 2011,158942360,150000,35485572,236)
(Fri Sep 16 16:14:28 EDT 2011,160947235,160000,37490447,234)
(Fri Sep 16 16:14:31 EDT 2011,163928570,170000,40471782,238)
(Fri Sep 16 16:14:34 EDT 2011,165923470,180000,42466682,235)
(Fri Sep 16 16:14:37 EDT 2011,168905234,190000,45448446,239)
(Fri Sep 16 16:14:40 EDT 2011,170896452,200000,47439664,237)
(Fri Sep 16 16:14:44 EDT 2011,173892450,210000,50435662,240)
(Fri Sep 16 16:14:46 EDT 2011,175864023,220000,52407235,238)
(Fri Sep 16 16:14:49 EDT 2011,178649350,230000,55192562,239)
(Fri Sep 16 16:14:52 EDT 2011,180753462,240000,57296674,238)
(Fri Sep 16 16:14:55 EDT 2011,183746025,250000,60289237,241)
(Fri Sep 16 16:14:57 EDT 2011,185729460,260000,62272672,239)
(Fri Sep 16 16:15:00 EDT 2011,187623450,270000,64166662,237)
(Fri Sep 16 16:15:03 EDT 2011,190726345,280000,67269557,240)
(Fri Sep 16 16:15:07 EDT 2011,193687450,290000,70230662,242)
(Fri Sep 16 16:15:09 EDT 2011,195682340,300000,72225552,240)
(Fri Sep 16 16:15:11 EDT 2011,197564023,310000,74107235,239)
(Fri Sep 16 16:15:16 EDT 2011,201769583,320000,78312795,244)
(Fri Sep 16 16:15:20 EDT 2011,204763581,330000,81306793,246)
(Fri Sep 16 16:15:22 EDT 2011,206748135,340000,83291347,244)
(Fri Sep 16 16:15:24 EDT 2011,208639571,350000,85182783,243)
(Fri Sep 16 16:15:27 EDT 2011,210745683,360000,87288895,242)
(Fri Sep 16 16:15:31 EDT 2011,214708356,370000,91251568,246)
(Fri Sep 16 16:15:34 EDT 2011,216598470,380000,93141682,245)
(Fri Sep 16 16:15:36 EDT 2011,218593460,390000,95136672,243)
(Fri Sep 16 16:15:49 EDT 2011,230687145,400000,107230357,268)
(Fri Sep 16 16:15:54 EDT 2011,234679580,410000,111222792,271)
(Fri Sep 16 16:15:56 EDT 2011,236571480,420000,113114692,269)
(Fri Sep 16 16:15:59 EDT 2011,238547016,430000,115090228,267)
(Fri Sep 16 16:16:01 EDT 2011,240639781,440000,117182993,266)
(Fri Sep 16 16:16:05 EDT 2011,243615780,450000,120158992,267)
(Fri Sep 16 16:16:08 EDT 2011,246508137,460000,123051349,267)
(Fri Sep 16 16:16:11 EDT 2011,248397560,470000,124940772,265)
(Fri Sep 16 16:16:13 EDT 2011,250493671,480000,127036883,264)
(Fri Sep 16 16:16:16 EDT 2011,253487016,490000,130030228,265)
(Fri Sep 16 16:16:20 EDT 2011,256379480,500000,132922692,265)
(Fri Sep 16 16:16:22 EDT 2011,258361470,510000,134904682,264)
(Fri Sep 16 16:16:25 EDT 2011,260458137,520000,137001349,263)
(Fri Sep 16 16:16:28 EDT 2011,263419780,530000,139962992,264)
(Fri Sep 16 16:16:30 EDT 2011,265314780,540000,141857992,262)
(Fri Sep 16 16:16:34 EDT 2011,268307145,550000,144850357,263)
(Fri Sep 16 16:16:37 EDT 2011,270398561,560000,146941773,262)
(Fri Sep 16 16:16:40 EDT 2011,273194560,570000,149737772,262)
(Fri Sep 16 16:16:42 EDT 2011,275186034,580000,151729246,261)
(Fri Sep 16 16:16:46 EDT 2011,278159460,590000,154702672,262)
(Fri Sep 16 16:16:48 EDT 2011,280364571,600000,156907783,261)
(Fri Sep 16 16:16:51 EDT 2011,283157046,610000,159700258,261)
(Fri Sep 16 16:16:54 EDT 2011,285139670,620000,161682882,260)
(Fri Sep 16 16:16:56 EDT 2011,287134560,630000,163677772,259)
(Fri Sep 16 16:17:00 EDT 2011,290317456,640000,166860668,260)
(Fri Sep 16 16:17:03 EDT 2011,293087561,650000,169630773,260)
(Fri Sep 16 16:17:06 EDT 2011,295083461,660000,171626673,260)
(Fri Sep 16 16:17:08 EDT 2011,297065134,670000,173608346,259)
(Fri Sep 16 16:17:13 EDT 2011,301279684,680000,177822896,261)
(Fri Sep 16 16:17:16 EDT 2011,304175682,690000,180718894,261)
(Fri Sep 16 16:17:19 EDT 2011,306158247,700000,182701459,261)
(Fri Sep 16 16:17:21 EDT 2011,308149672,710000,184692884,260)
(Fri Sep 16 16:17:24 EDT 2011,310256784,720000,186799996,259)
(Fri Sep 16 16:17:28 EDT 2011,314028567,730000,190571779,261)
(Fri Sep 16 16:17:30 EDT 2011,315987460,740000,192530672,260)
(Fri Sep 16 16:17:33 EDT 2011,317982450,750000,194525662,259)
(Fri Sep 16 16:17:35 EDT 2011,319865024,760000,196408236,258)
(Fri Sep 16 16:17:38 EDT 2011,321968570,770000,198511782,257)
(Fri Sep 16 16:17:42 EDT 2011,325961470,780000,202504682,259)
(Fri Sep 16 16:17:45 EDT 2011,327946015,790000,204489227,258)
(Fri Sep 16 16:17:47 EDT 2011,329817560,800000,206360772,257)
(Fri Sep 16 16:18:00 EDT 2011,341925670,810000,218468882,269)
(Fri Sep 16 16:18:05 EDT 2011,345907126,820000,222450338,271)
(Fri Sep 16 16:18:07 EDT 2011,347896250,830000,224439462,270)
(Fri Sep 16 16:18:10 EDT 2011,349781250,840000,226324462,269)
(Fri Sep 16 16:18:12 EDT 2011,351876024,850000,228419236,268)
(Fri Sep 16 16:18:16 EDT 2011,354869270,860000,231412482,269)
(Fri Sep 16 16:18:19 EDT 2011,357841260,870000,234384472,269)
(Fri Sep 16 16:18:21 EDT 2011,359726014,880000,236269226,268)
(Fri Sep 16 16:18:24 EDT 2011,361829570,890000,238372782,267)
(Fri Sep 16 16:18:27 EDT 2011,364812570,900000,241355782,268)
(Fri Sep 16 16:18:31 EDT 2011,367805124,910000,244348336,268)
(Fri Sep 16 16:18:33 EDT 2011,369587240,920000,246130452,267)
(Fri Sep 16 16:18:35 EDT 2011,371692450,930000,248235662,266)
(Fri Sep 16 16:18:39 EDT 2011,374685012,940000,251228224,267)
(Fri Sep 16 16:18:41 EDT 2011,376549280,950000,253092492,266)
(Fri Sep 16 16:18:44 EDT 2011,379541260,960000,256084472,266)
(Fri Sep 16 16:18:47 EDT 2011,381647025,970000,258190237,266)
(Fri Sep 16 16:18:50 EDT 2011,384619570,980000,261162782,266)
(Fri Sep 16 16:18:52 EDT 2011,386512470,990000,263055682,265)
(Fri Sep 16 16:18:56 EDT 2011,389506124,1000000,266049336,266)
(Fri Sep 16 16:18:58 EDT 2011,391587460,1010000,268130672,265)
(Fri Sep 16 16:19:02 EDT 2011,394581260,1020000,271124472,265)
(Fri Sep 16 16:19:04 EDT 2011,396475012,1030000,273018224,265)
(Fri Sep 16 16:19:06 EDT 2011,398457260,1040000,275000472,264)
(Fri Sep 16 16:19:11 EDT 2011,402673581,1050000,279216793,265)
(Fri Sep 16 16:19:15 EDT 2011,405638127,1060000,282181339,266)
(Fri Sep 16 16:19:17 EDT 2011,407529681,1070000,284072893,265)
(Fri Sep 16 16:19:19 EDT 2011,409523671,1080000,286066883,264)
(Fri Sep 16 16:19:23 EDT 2011,412608357,1090000,289151569,265)
(Fri Sep 16 16:19:26 EDT 2011,415398670,1100000,291941882,265)

*/